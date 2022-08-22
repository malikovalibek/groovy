import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.event.type.EventDispatchOption;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.Issue;

//def issue = ComponentAccessor.issueManager.getIssueByCurrentKey("");
def issue = event.issue;
def customFieldManager = ComponentAccessor.getCustomFieldManager();
def newCField = customFieldManager.getCustomFieldObject("customfield_13700"); //Secondary
def user = ComponentAccessor.userManager.getUserByName("r.bot");
def usersGroup = issue.getCustomFieldValue(newCField);
def userObject, component, usersToAdd;

issue.getComponents().each {
    if (it.getName() == '1. Наблюдательный совет') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '01. Генеральный директор') {
        usersToAdd = ['n.hasanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '02.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '03.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '04.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '05.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '06.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '07.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '08. Управление бух. учета и отчетности') {
        usersToAdd = ['a.akhunbaev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '09.') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '10. Управление СРиИП') {
        usersToAdd = ['a.togaev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '11. Управление эксплуатации СТ') {
        usersToAdd = ['a.asilov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '12. Управление международного СипРсОС') {
        usersToAdd = ['a.rasulov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '13. Управление безопасности') {
        usersToAdd = ['h.keldiev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '14. Юридическое управление') {
        usersToAdd = ['b.jurayev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '15. Управление кап. строительства') {
        usersToAdd = ['t.tursunov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '16. Управление по ВсПО') {
        usersToAdd = ['ai.yusupov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '17. Управление БПиФА') {
        usersToAdd = ['d.nuritdinova']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '18. Управление КОиКИП') {
        usersToAdd = ['s.ollaberganov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '19. Управление по ВсГО') {
        usersToAdd = ['d.kamilov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '20. Управление по ТКиСГМ') {
        usersToAdd = ['m.ahmedov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '21. Управление делами/Служба АиОО') {
        usersToAdd = ['n.husanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '22. Служба по охране труда и ТБ') {
        usersToAdd = ['k.sadikkhodjaev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '23. Отдел кадастра ЗиС') {
        usersToAdd = ['az.arifdjanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '24. Служба системы МКиС') {
        usersToAdd = ['l.kartsevich']
       usersToAdd.each {
           userObject = ComponentAccessor.userManager.getUserByName(it)
           if (usersGroup == null) {
               usersGroup = []
               usersGroup.add(userObject)
           } else if (!usersGroup.contains(userObject)) {
					usersGroup.add(userObject)
           }
      }
   }
    if (it.getName() == '25. Управление маркетинга и РБ') {
        usersToAdd = ['sh.shamansurov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '26. Управление по развитию ПиО') {
        usersToAdd = ['v.usmanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '27. Служба документооборота и контроля') {
        usersToAdd = ['a.tursunov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '28. Служба по работе с ОЮиФЛ') {
        usersToAdd = ['m.shukurov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '29. Управление ЭБиК') {
        usersToAdd = ['r.toshpulatov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '30. Управ. по координации М-ТОвЧИ') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '31. Управление мониторинга по ФиРПЛ') {
        usersToAdd = ['m.mirzohidov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '32. Отдел специальных работ') {
        usersToAdd = ['a.alimshayev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '33. Отдел по мобилизационной РиГЗ') {
        usersToAdd = ['gz.aripova']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '34. Отдел воинского УиБК') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '35. Диспетчерская служба') {
        usersToAdd = ['a.mahmudov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '36. Профком') {
        usersToAdd = ['b.jurayev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '37. Консультант при НС') {
        usersToAdd = ['']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '38. Консультант по пресс-службе') {
        usersToAdd = ['t.mamadjanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '39. Телеком Дата') {
        usersToAdd = ['d.shorahmedov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '40. ТТТ') {
        usersToAdd = ['a.goibnazarov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '41. Узмобайл') {
        usersToAdd = ['s.sfakhrutdinov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '42. ГЦК') {
        usersToAdd = ['s.arifhanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '43. Инфосистемы') {
        usersToAdd = ['a.djuraev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '44. ЦРТиП') {
        usersToAdd = ['u.alamov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '45. ЦПиО') {
        usersToAdd = ['ya.tulyaganov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '46. ЦУЗ') {
        usersToAdd = ['l.inagamov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '47. ТШТТ') {
        usersToAdd = ['f.rustamov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '48. Ташкент обл.') {
        usersToAdd = ['sh.bakirov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '49. Каракалпакстан') {
        usersToAdd = ['q.tajenov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '50. Андижан') {
        usersToAdd = ['sh.nakhmedov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '51. Бухара') {
        usersToAdd = ['kh.turdiev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '52. Джизак') {
        usersToAdd = ['u.karshibaev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '53. Кашкадарья') {
        usersToAdd = ['sh.juraev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '54. Навоий') {
        usersToAdd = ['j.djoraev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '55. Наманган') {
        usersToAdd = ['kh.khodjaev']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '56. Самарканд') {
        usersToAdd = ['t.sultanov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '57. Сурхандарья') {
        usersToAdd = ['sh.norkuchkarov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '58. Сырдарья') {
        usersToAdd = ['s.sakhmedov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '59. Фергана') {
        usersToAdd = ['v.yejkov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
    if (it.getName() == '60. Хорезм') {
        usersToAdd = ['a.samandarov']
        usersToAdd.each {
            userObject = ComponentAccessor.userManager.getUserByName(it)
            if (usersGroup == null) {
                usersGroup = []
                usersGroup.add(userObject)
            } else if (!usersGroup.contains(userObject)) {
                usersGroup.add(userObject)
            }
        }
    }
} 

issue.setCustomFieldValue(newCField, usersGroup)
    ComponentAccessor.getIssueManager().updateIssue(user, issue, EventDispatchOption.ISSUE_UPDATED, false)
