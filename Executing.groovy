import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.bc.issue.search.SearchService
import com.atlassian.jira.jql.parser.JqlQueryParser
import com.atlassian.jira.web.bean.PagerFilter
 
def jqlQueryParser = ComponentAccessor.getComponent(JqlQueryParser)
def searchService = ComponentAccessor.getComponent(SearchService)
def issueManager = ComponentAccessor.getIssueManager()
def user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser()
 
// edit this query to suit
def query = jqlQueryParser.parseQuery("project = DOC and assignee = currentUser()")
 
def search = searchService.search(user, query, PagerFilter.getUnlimitedFilter())
 
log.debug("Total issues: ${search.total}")
 
search.results.each { documentIssue ->
    log.debug(documentIssue.key)
 
    // if you need a mutable issue you can do:
    def issue = issueManager.getIssueObject(documentIssue.id)
 
    // do something to the issue...
    log.debug(issue.summary)
}
//The code below demonstrates how to execute a JQL query, which may be useful in a validator or post-function etc. This code can also be tested from the Script Console.
