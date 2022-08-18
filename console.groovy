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


UserPropertyManager userPropertyManager = ComponentAccessor.getUserPropertyManager()


def log = Logger.getLogger("com.acme.workflows")
//------------------------------------------------------
def issue = ComponentAccessor.issueManager.getIssueObject("DOC-55299")

ApplicationUser currentUser = ComponentAccessor.userManager.getUserByName("a.malikov")
assert issue: "Could not find currentUser with currentUserName $currentUser"
// def event = event;
// def issuee = event.issue;
assert issue: "Could not find issue with key $issue"
//def event = event as IssueEvent;
// def changeHistoryManager = ComponentAccessor.getChangeHistoryManager();
//def issue = event.getIssue() as MutableIssue;

////////////////GetCustomFields////////////////////
def customfield_13316 = 13316L; //Primary       ///
def customfield_13317 = 13317L; //Secondary     ///
def customfield_10032 = 10032L; //Soispolniteli ///
///////////////////////////////////////////////////
assert issue: "Could not find field $customfield_13316"
assert issue: "Could not find field $customfield_13317"
assert issue: "Could not find field $customfield_10032"

///////////////GetCustomFieldsValues//////////////////////////////////////////////
def customfield_13316_value = getCustomFieldValue(issue, customfield_13316)?:[];//
def customfield_13317_value = getCustomFieldValue(issue, customfield_13317)?:[];//
def customfield_10032_value = getCustomFieldValue(issue, customfield_10032)?:[];//
//////////////////////////////////////////////////////////////////////////////////
assert issue: "Could not find field value $customfield_13316_value"
assert issue: "Could not find field value $customfield_13317_value"
assert issue: "Could not find field value $customfield_10032_value"

///////////////GetArrayIfComponents/////////////
def arrayOfComponents = issue.getComponents();//
////////////////////////////////////////////////
assert issue: "Could not find component $arrayOfComponents"
///////////////GetIssueType/////////////////
def issueType = issue.issueTypeObject.name//
////////////////////////////////////////////
assert issue: "Could not find issue Type $issueType"
def dialog = null;
//////////////GetUserProperty/////////////////////////////////////////////////////////////////
def userProperty = ComponentAccessor.getUserPropertyManager();                              //
def userProperty_val = userProperty.getPropertySet(currentUser).getString('jira.meta.TemplateID')  //
//////////////////////////////////////////////////////////////////////////////////////////////
String signer_fio = userPropertyManager.getPropertySet(currentUser).getString('jira.meta.TemplateID');

// def issuee = event.issue;
// assert issue: "Could not find issue with key $issue"
// def event = event as IssueEvent;
// def changeHistoryManager = ComponentAccessor.getChangeHistoryManager();

// //////////getChangeLog//////////////////////////////////////////////////////
// def changelog = event.getChangeLog();                                       //
// log.error "component field listener (1.1) changelog: " + changelog          //
// def changedFields = findFieldsMentionedInChangeLog(changelog)               //
// log.error "component field listener (1.2) changedFields: " + changedFields  //
// ////////////////////////////////////////////////////////////////////////////

def UsersToAdd = [];
    
    if (userPropertyManager.getPropertySet(currentUser).getString('jira.meta.TemplateID') != null){
        for (def comp in arrayOfComponents){
            if (["Технический блок"].contains (comp.getName())) {
                def usersFromGP = getUsersInGroup(getGroup("Тех.блок"))
                for (def userGP in usersFromGP) {
                    if (!customfield_13316_value.contains(userGP)){
                      UsersToAdd.addAll(userGP)                        
                    }                 
                }
                customfield_13316_value.addAll(UsersToAdd)
                updateCustomFieldValue(issue, customfield_13316, customfield_13316_value, currentUser);
            }
       }
    }else{
        for (def comp in arrayOfComponents){
             if (["Технический блок"].contains (comp.getName())) {
                def usersFromGP = getUsersInGroup(getGroup("Тех.блок"))
                 for (def userGP in usersFromGP) {
                     if (!customfield_13317_value.contains(userGP) || !customfield_10032_value.contains(userGP)){
                       UsersToAdd.addAll(userGP)                        
                     }                 
                 }
                 customfield_13317_value.addAll(UsersToAdd)
                 customfield_10032_value.addAll(UsersToAdd)
                 updateCustomFieldValue(issue, customfield_13317, customfield_13317_value, currentUser);
                 updateCustomFieldValue(issue, customfield_10032, customfield_10032_value, currentUser);
             }
         }     
     }
    
// //____________________Функция получающая даннык с журнала изменений_______________
//   def Set<String> findFieldsMentionedInChangeLog(GenericValue changelog) {  //
//       Set<String> fields = [];                        //
//       def childEventChanges = changelog.getRelated("ChildChangeItem");    //
//         for (childEventChange in childEventChanges) {            //
//           fields.add(childEventChange.getString("field"))            //
//         }                                  //
//         fields;                                //
//   }                                      //
// //______________________________________________________________________________//

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
