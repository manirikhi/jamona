package com.ems.blog.exception;

public enum ErrorCodes {

        // Scheduler Service related errors
        INFO_NOT_FOUND(1, "[%s] information is not available."),
        CREATE_ERROR(2, "Error ocurred while creating the [%s]."),
        UPDATE_ERROR(3, "Error ocurred while updating the [%s]."),
        DELETE_ERROR(4, "Error Ocurred while deleting the [%s]."),
        GET_ERROR(5, "Error Ocurred while fetching the [%s]."),        
        SCHEDULE_IN_PROGRESS(6, "Schedule to be updated is in progress, hence cannot be updated/deleted."),
        SCHEDULE_ALREADY_EXISTS(7, "Schedule already exists in database."),
        INVALID_CRON_EXPRESSION(8, "Invalid CRON expression [%s]"),
        SCHEDULE_OVERLAPS(9, "Current schedule overlaps with existing job schedule at [%s] at [%s] execution."),
        JOB_IN_PROGRESS_ERROR(10, "Error Ocurred while fetching the InProgress jobs."),        TEMPLATE_EXISTS_WITH_SAME_NAME(11,"JobTemplate exists with same name for Project and Client."),        PROJECT_OR_CLIENT_INFO_REQUIRED(12,"Project/Client information is required."),        LAUNCH_JOB_ERROR(13, "Error in launching job"),        ENTITY_REQUIRED_IN_LAUNCH_JOB(14, "[%s] required for launching job"),
        UNKNOWN_ERROR(15, "Unknown Error ocurred while [%s]."),
        CLIENT_NAME_ALREADY_EXISTS(16, "Client Exists with [%s] name."),        ANOTHER_JOB_IS_IN_PROGRESS(17,"Another Job is in progress so job cannot be [%s]."),         MAIL_ERROR(18,"Error occured while sending the [%s].");
        
        private final int code;
        private final String description;


        private ErrorCodes(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return "[E"+code+"]";
        }

        @Override
        public String toString() {
            return "[E"+code+"] "+description;
        }

        public String format(Object... args) {
            return "[E"+code+"] "+ String.format(description, args);
        }
}
