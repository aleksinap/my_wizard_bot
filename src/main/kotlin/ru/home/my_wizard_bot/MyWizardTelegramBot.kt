package ru.home.my_wizard_bot

import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.bots.TelegramWebhookBot
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException

class MyWizardTelegramBot(botOptions: DefaultBotOptions?) : TelegramWebhookBot(botOptions) {
    private lateinit var webHookPath: String
    private lateinit var botUserName: String
    private lateinit var botToken: String


    override fun getBotToken(): String = botToken

    override fun getBotUsername(): String = botUserName

    override fun getBotPath(): String = webHookPath

    override fun onWebhookUpdateReceived(update: Update): BotApiMethod<*>? {
        if (update.message != null && update.message.hasText()) {
            val chatId = update.message.chatId.toString()
            try {
                execute(SendMessage(chatId, "Hi, ${update.message.text}!"))
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
        return null
    }

    fun setWebHookPath(webHookPath: String) {
        this.webHookPath = webHookPath
    }

    fun setBotUserName(botUserName: String) {
        this.botUserName = botUserName
    }

    fun setBotToken(botToken: String) {
        this.botToken = botToken
    }
}