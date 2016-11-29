package com.example.plugins.tutorial.crud.action;

import com.atlassian.jira.permission.GlobalPermissionKey;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.example.plugins.tutorial.crud.manager.StatusReportManager;
//import epam.jira.pptx.manager.StatusReportManager;

public abstract class DefaultSupport extends JiraWebActionSupport {

    protected static final String PERMISSION_VIOLATION = "permissionviolation";
    protected static final String SUCCESS = "success";
    protected static final String ERROR = "error";

    protected final StatusReportManager statusReportManager;

    public DefaultSupport(final StatusReportManager statusReportManager) {
        this.statusReportManager = statusReportManager;
    }

    @Override
    public String doDefault() {
        if (!hasPermission()) {
            return PERMISSION_VIOLATION;
        } else {
            return SUCCESS;
        }
    }

    protected boolean hasPermission() {
        return hasGlobalPermission(GlobalPermissionKey.ADMINISTER);
    }
}
