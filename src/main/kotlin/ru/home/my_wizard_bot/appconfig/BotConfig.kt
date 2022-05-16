package ru.home.my_wizard_bot.appconfig

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.bots.DefaultBotOptions
import ru.home.my_wizard_bot.MyWizardTelegramBot


@Configuration
class BotConfig(private val botConfigProperties: BotConfigProperties) {

    @Bean
    fun MySuperTelegramBot(): MyWizardTelegramBot {
        val options = DefaultBotOptions()

        val bot = MyWizardTelegramBot(options)
        bot.setBotUserName(botConfigProperties.botUserName)
        bot.botToken = botConfigProperties.botToken
        bot.setWebHookPath(botConfigProperties.webHookPath)

        return bot
    }

}