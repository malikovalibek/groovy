import com.atlassian.crowd.embedded.api.User
import com.atlassian.jira.user.ApplicationUser
import com.atlassian.jira.bc.issue.search.SearchService
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.web.bean.PagerFilter

enableCache = {-> false}

def text = ""
def epicStatusShouldBe = "IN PROD"
text =  text + "Start: " + issue.summary + " - "

SearchService searchService = ComponentAccessor.getComponent(SearchService.class)
User user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
IssueManager issueManager = ComponentAccessor.getIssueManager()
List<Issue> issues = null

def jqlSearchIssues = "issueFunction in linkedIssuesOf(\"project = RPP AND issueFunction in linkedIssuesOf(\\\"issueKey = " + issue.id + "\\\")\")"
SearchService.ParseResult parseResult =  searchService.parseQuery(user, jqlSearchIssues)

if (parseResult.isValid()) {
    def searchResult = searchService.search(user, parseResult.getQuery(), PagerFilter.getUnlimitedFilter())
    issues = searchResult.issues.collect {issueManager.getIssueObject(it.id)}
    issues?.each {curIssue ->
      def status = curIssue.getStatusObject()
      text += curIssue.getKey() + ":" + status.getName() + " / "
      if( status.getName() != "TERMINATED" ) {
          if( status.getName() == "BLOCKED")
            epicStatusShouldBe = status
          if( epicStatusShouldBe == "IN PROD")
            epicStatusShouldBe = status
          if( epicStatusShouldBe == "DONE" && status.getName() != "IN PROD" && status.getName() != "BLOCKED")
            epicStatusShouldBe = status
          if( epicStatusShouldBe == "INTEGRATED" && status.getName() != "IN PROD" && status.getName() != "DONE" && status.getName() != "BLOCKED")
            epicStatusShouldBe = status
          if( epicStatusShouldBe == "ON GOING" && status.getName() != "IN PROD" && status.getName() != "DONE" && status.getName() != "INTEGRATED" && status.getName() != "BLOCKED")
            epicStatusShouldBe = status
          if( epicStatusShouldBe == "READY" && status.getName() != "IN PROD" && status.getName() != "DONE" && status.getName() != "INTEGRATED" && status.getName() != "ON GOING" && status.getName() != "BLOCKED")
            epicStatusShouldBe = status
          if( epicStatusShouldBe == "NEW" && status.getName() != "IN PROD" && status.getName() != "DONE" && status.getName() != "INTEGRATED" && status.getName() != "ON GOING" && status.getName() != "READY" && status.getName() != "BLOCKED")
            epicStatusShouldBe = status
      }
    }

} else {
   return "Invalid JQL: " + jqlSearchIssues
} 

def jqlSearchEpic = "project = RPP AND issueFunction in linkedIssuesOf(\"issueKey =  " + issue.id + "\")"
parseResult =  searchService.parseQuery(user, jqlSearchEpic)

if (parseResult.isValid()) {
    def searchResult = searchService.search(user, parseResult.getQuery(), PagerFilter.getUnlimitedFilter())
    def epic = searchResult.issues.collect {issueManager.getIssueObject(it.id)} // is a list
	text = "["+epic[0].summary+"] " + text
} else {
   return "Invalid JQL: " + jqlSearchEpic
}

text += " --> " + (epicStatusShouldBe.getName() as String)
//return text as String
return epicStatusShouldBe.getName() as String
