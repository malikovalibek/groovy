import javax.ws.rs.core.Response
import com.atlassian.jira.user.UserPropertyManager
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.jira.user.ApplicationUser
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.crowd.embedded.api.Group
import org.apache.log4j.Logger
import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.jira.event.issue.IssueEvent
import com.atlassian.jira.issue.MutableIssue
import org.ofbiz.core.entity.GenericValue
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.event.issue.IssueEvent
import com.atlassian.jira.event.type.EventDispatchOption
import com.atlassian.jira.issue.fields.CustomField
import com.atlassian.jira.user.ApplicationUser
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.crowd.embedded.api.Group
import com.atlassian.jira.user.UserPropertyManager
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType


UserPropertyManager userPropertyManager = ComponentAccessor.getUserPropertyManager();


def log = Logger.getLogger("com.acme.workflows");
//------------------------------------------------------
//def issue = ComponentAccessor.issueManager.getIssueObject("DOC-55299");

ApplicationUser currentUser = ComponentAccessor.userManager.getUserByName("a.malikov");
def issuee = event.issue;
// assert issue: "Could not find issue with key $issue"
def event = event as IssueEvent;
def changeHistoryManager = ComponentAccessor.getChangeHistoryManager();

//def issue = event.getIssue() as MutableIssue;

//////////getChangeLog//////////////////////////////////////////////////////
def changelog = event.getChangeLog();                                       //
log.error "component field listener (1.1) changelog: " + changelog          //
def changedFields = findFieldsMentionedInChangeLog(changelog)               //
log.error "component field listener (1.2) changedFields: " + changedFields  //
////////////////////////////////////////////////////////////////////////////

////////////////GetCustomFields////////////////////
def customfield_10032 = 10032L; //Soispolniteli ///
def customfield_13317 = 13317L; //Secondary     ///
///////////////////////////////////////////////////

///////////////GetCustomFieldsValues//////////////////////////////////////////////
def customfield_10032_value = getCustomFieldValue(issue, customfield_10032)?:[];//
def customfield_13317_value = getCustomFieldValue(issue, customfield_13317)?:[];//
//////////////////////////////////////////////////////////////////////////////////

def UsersToAdd = [];//customfield_13317_value += customfield_10032_value

if (changedFields.contains("Secondary")){
    def usersFromCF = getCustomFieldValue(issue, customfield_13317)?:[];
        for (def exUser in usersFromCF){
            if (!customfield_10032_value.contains(exUser))
            UsersToAdd.addAll(exUser)

        }
        customfield_10032_value.addAll(UsersToAdd)
        updateCustomFieldValue(issue, customfield_10032, customfield_10032_value, currentUser);
}

//____________________Функция получающая даннык с журнала изменений_______________
  def Set<String> findFieldsMentionedInChangeLog(GenericValue changelog) {      //
      Set<String> fields = [];                                                  //
      def childEventChanges = changelog.getRelated("ChildChangeItem");          //
        for (childEventChange in childEventChanges) {                           //
          fields.add(childEventChange.getString("field"))                       //
        }                                                                       //
        fields;                                                                 //
  }                                                                             //
//______________________________________________________________________________//
def getCustomFieldValue(issue, Long fieldId) {
    issue.getCustomFieldValue(ComponentAccessor.customFieldManager.getCustomFieldObject(fieldId))
}
def getUsersInGroup(group) {
ComponentAccessor.getGroupManager().getUsersInGroup(group)
}
def getGroup(String groupName) {
ComponentAccessor.getGroupManager().getGroup(groupName)
}
def updateCustomFieldValue(issue, Long customFieldId, newValue, user) {
def customField = ComponentAccessor.customFieldManager.getCustomFieldObject(customFieldId)
issue.setCustomFieldValue(customField, newValue)
ComponentAccessor.issueManager.updateIssue(user, issue, EventDispatchOption.ISSUE_UPDATED, false)
}
