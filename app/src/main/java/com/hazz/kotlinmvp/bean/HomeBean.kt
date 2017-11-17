package com.hazz.kotlinmvp.bean


/**
 * Created by xuhao on 2017/11/16.
 * desc:
 */
data class HomeBean(var issueList: ArrayList<Issue>, val nextPageUrl: String, val nextPublishTime: Long, val newestIssueType: String, val dialog: Any) {

    override fun toString(): String {
        return "HomeBean(issueList=$issueList, nextPageUrl='$nextPageUrl', nextPublishTime=$nextPublishTime, newestIssueType='$newestIssueType', dialog=$dialog)"
    }
}

