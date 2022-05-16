package ru.home.my_wizard_bot.appconfig

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "telegrambot")
data class BotConfigProperties(
    var botUserName: String = "",
    var webHookPath: String = "",
    var botToken: String = ""
)