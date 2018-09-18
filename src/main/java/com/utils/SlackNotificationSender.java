package com.utils;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;

public class SlackNotificationSender {
        private SlackApi api;

        public SlackNotificationSender() {
            this.api = new SlackApi("https://hooks.slack.com/services/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");
        }

        public void sendDefaultSlackNotification(String message) {
            this.api.call(new SlackMessage(message).setLinkNames(true));
        }

    }
