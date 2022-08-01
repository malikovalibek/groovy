import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder;
import com.atlassian.jira.issue.ModifiedValue;
import com.atlassian.jira.issue.MutableIssue
import com.atlassian.jira.issue.link.IssueLinkManager
import com.atlassian.jira.user.ApplicationUser
import com.atlassian.crowd.embedded.api.User
import com.atlassian.jira.user.util.UserManager
import com.atlassian.jira.ComponentManager
import com.atlassian.jira.event.type.EventDispatchOption
import org.apache.log4j.Category
import com.atlassian.jira.issue.watchers.IssueWatcherAccessor
import com.atlassian.jira.issue.watchers.WatcherManager
import com.atlassian.jira.issue.CustomFieldManager
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.user.util.DefaultUserManager
import com.atlassian.jira.issue.IssueManager
import com.atlassian.jira.issue.util.IssueChangeHolder
import com.atlassian.jira.user.util.UserUtil;
import org.apache.log4j.Logger;
 

Logger log = Logger.getLogger("Deletion of Watchers from the issue");
log.setLevel(org.apache.log4j.Level.DEBUG);
def logPrefix ="Deletion of Watchers from the issue" + issue.getKey() + "***********************************************************************************" ;
IssueChangeHolder changeHolder = new DefaultIssueChangeHolder(); 
List<ApplicationUser> users = new ArrayList<ApplicationUser>();

try{
 
 Locale en = new Locale("en");
 IssueWatcherAccessor iwa = ComponentAccessor.getComponent(IssueWatcherAccessor.class)
 def list = iwa.getWatchers(issue,en);
 log.debug(logPrefix+ "All watchers are::" + list); 
 
 CustomFieldManager customFieldManager = ComponentAccessor.getCustomFieldManager(); 
 def cfCustomerWatchers = "Customer Watchers";
 cfCustomerWatchersObj = customFieldManager.getCustomFieldObjectByName(cfCustomerWatchers);
 
 for (i in list )
 {
 def user = i;
 def watcherUser = ComponentAccessor.getUserManager().getUserByKey(user.toString().split(":")[0]);
 def emailIDUser = watcherUser.getEmailAddress();
 
 

 if(!emailIDUser.contains("abc.com") && !emailIDUser.contains("def.com") && !emailIDUser.contains("ghz.com") )
 { 
 def watcherManager = ComponentAccessor.getWatcherManager();
 watcherManager.stopWatching(user, issue);
 log.debug(logPrefix + "Current removed watcher emailID is :: " + emailIDUser); 
 users.add(ComponentAccessor.getUserManager().getUserByName(user.toString().split(":")[0]))
 }
 }
 cfCustomerWatchersObj.updateValue(null, issue, new ModifiedValue("", users), changeHolder); 
}
catch(Exception e){
 log.error(logPrefix + e.getMessage());
}
