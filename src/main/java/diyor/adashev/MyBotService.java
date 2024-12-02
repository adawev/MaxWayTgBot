package diyor.adashev;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.*;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static diyor.adashev.MyBot.userList;

public class MyBotService {
    public SendMessage sendMessage(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Xush kelibsiz!");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();

        button.setText("O'zbek tili");
        row.add(button);
        rowList.add(row);

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Rus tili");
        row.add(button1);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Ingliz tili");
        row.add(button2);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;




    }
    public SendMessage shareContact(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Telefon raqamingizni jo'nating");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Share Contact");
        button.setRequestContact(true);
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }
    public SendMessage menuMain(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("""
                Buyurtma berishni boshlash uchun 🛍 Buyurtma berish tugmasini bosing
                \s
                Shuningdek, aksiyalarni ko'rishingiz va bizning filiallar bilan tanishishingiz mumkin.
                
                https://www.maxway.uz
                """);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton btnBuyurtma = new KeyboardButton();
        btnBuyurtma.setText("\uD83D\uDECD Buyurtma berish");
        row.add(btnBuyurtma);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton btnAksiya = new KeyboardButton();
        btnAksiya.setText("\uD83C\uDF89 Aksiya");
        row1.add(btnAksiya);

        KeyboardButton btnFilial = new KeyboardButton();
        btnFilial.setText("\uD83C\uDFD8 Barcha filiallarimiz");
        row1.add(btnFilial);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton btnMyBuyurtmalarim = new KeyboardButton();
        btnMyBuyurtmalarim.setText("\uD83D\uDCC3 Mening buyurtmalarim");
        row2.add(btnMyBuyurtmalarim);

        KeyboardButton btnIzoh = new KeyboardButton();
        btnIzoh.setText("✍\uFE0F Izoh qoldirish");
        row2.add(btnIzoh);
        rowList.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton btnVakansiya = new KeyboardButton();
        btnVakansiya.setText("\uD83D\uDCBC Vakansiyalar");
        row3.add(btnVakansiya);

        KeyboardButton btnBizHaqimizda = new KeyboardButton();
        btnBizHaqimizda.setText("ℹ\uFE0F Biz haqimizda");
        row3.add(btnBizHaqimizda);
        rowList.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        KeyboardButton btnSettings = new KeyboardButton();
        btnSettings.setText("⚙\uFE0F Sozlamalar");
        row4.add(btnSettings);
        rowList.add(row4);


        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;



    }
    public SendMessage buyurtma(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Yetkazib berish turini tanlang");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Olib ketish");
        row.add(button);
        rowList.add(row);

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Yetkazib berish");
        row.add(button1);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton buttonOrqaga = new KeyboardButton();
        buttonOrqaga.setText("⬅\uFE0F Orqaga");
        row1.add(buttonOrqaga);
        rowList.add(row1);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;



    }
    public SendPhoto aksiya(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F4e201550-8df1-41a7-be2c-b32b3ca479e4&w=1920&q=75"));
        sendPhoto.setCaption("Tasty klab aksiyasi \n" +
                " Issiq yoki to'yimli! Yangi TastyClub sendvichini tatib ko'ring va o'zingiz tanlagan isituvchi qahva yoki kartoshka fri sovg'asini oling!!!");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);
        return sendPhoto;

    }

    public SendMessage filials(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Bizning filiallarimiz:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("▶\uFE0F Oldinga");
        row.add(button1);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton buttonF1 = new KeyboardButton();
        buttonF1.setText("Max Way BERUNIY");
        row1.add(buttonF1);

        KeyboardButton buttonF2 = new KeyboardButton();
        buttonF2.setText("Max Way MEGA PLANET");
        row1.add(buttonF2);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton buttonF3 = new KeyboardButton();
        buttonF3.setText("Max Way AVIASOZLAR");
        row2.add(buttonF3);

        KeyboardButton buttonF4 = new KeyboardButton();
        buttonF4.setText("Max Way RISOVIY");
        row2.add(buttonF4);
        rowList.add(row2);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }
    public SendMessage filial2(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Bizning filiallarimiz:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("◀\uFE0F Orqaga");
        row.add(button);

        KeyboardButton buttonF1 = new KeyboardButton();
        buttonF1.setText("Max Way SAYRAM");
        row.add(buttonF1);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton buttonF2 = new KeyboardButton();
        buttonF2.setText("Max Way MAKSIM GORKIY");
        row1.add(buttonF2);

        KeyboardButton buttonF3 = new KeyboardButton();
        buttonF3.setText("Max Way SERGELI");
        row1.add(buttonF3);
        rowList.add(row1);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;


    }
    public SendMessage myBuyurtmalarim(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Sizda buyurtmalar yo'q");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("\uD83D\uDDC2 | Asosiy menu");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;


    }
    public SendMessage izoh(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Izoh qoldiring. Sizning fikringiz biz uchun muhim");


        
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage izohQoldi(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Izohingiz uchun rahmat");
        return sendMessage;
    }

    public SendPhoto bizHaqimizda(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20logo&imgurl=https%3A%2F%2Fmaxway.uz%2Fimages%2Fmaxway_cover.png&imgrefurl=https%3A%2F%2Fmaxway.uz%2F&docid=PDm5feUz-FKZJM&tbnid=QeeKsK8v-1-eJM&vet=12ahUKEwjLx9z7096JAxUNKhAIHdkUFo4QM3oECBgQAA..i&w=1281&h=908&hcb=2&ved=2ahUKEwjLx9z7096JAxUNKhAIHdkUFo4QM3oECBgQAA"));
        sendPhoto.setCaption("\uD83C\uDF5F Max Way \n" +
                "☎\uFE0F Aloqa markazi: +998712005400");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendPhoto.setReplyMarkup(replyKeyboardMarkup);
        return sendPhoto;


    }
    public SendMessage vakansiyalar(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Afsuski xozirda bizlarda vakansiyalar mavjud emas.");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        rowList.add(row);
        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }
    public SendMessage settings(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Sozlamani tanlang");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("\uD83C\uDDFA\uD83C\uDDFF Tilni o'zgartirish");
        row.add(button);
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("Tug'ilgan kunni qo'shish");
        row.add(button1);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button2 = new KeyboardButton();
        button2.setText("Telefon raqamni o'zgartirish");
        row1.add(button2);

        KeyboardButton button3 = new KeyboardButton();
        button3.setText("⬅\uFE0F Orqaga");
        row1.add(button3);
        rowList.add(row1);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage olibKetish(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Filialni tanlang");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);

        KeyboardButton button1 = new KeyboardButton();
        button1.setText("\uD83D\uDCCD Eng yaqin filialni aniqlash");
        button1.setRequestLocation(true);
        row.add(button1);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton buttonF1 = new KeyboardButton();
        buttonF1.setText("MAX WAY BERUNIY ");
        row1.add(buttonF1);

        KeyboardButton buttonF2 = new KeyboardButton();
        buttonF2.setText("MAX WAY MEGA PLANET ");
        row1.add(buttonF2);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton buttonF3 = new KeyboardButton();
        buttonF3.setText("MAX WAY AVIASOZLAR ");
        row2.add(buttonF3);

        KeyboardButton buttonF4 = new KeyboardButton();
        buttonF4.setText("MAX WAY RISOVIY ");
        row2.add(buttonF4);
        rowList.add(row2);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage yetkazibBerish(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Buyurtmani davom ettirish uchun iltimos lokatsiyangizni yuboring");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Lokatsiya yuborish");
        button.setRequestLocation(true);
        row.add(button);
        rowList.add(row);
        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");
        row1.add(button1);
        rowList.add(row1);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;

    }
    public SendMessage menu(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Kategoriyani tanlang");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("Interaktiv menyu");
        row.add(button);
        rowList.add(row);

        KeyboardRow row1 = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton();
        button1.setText("⬅\uFE0F Orqaga");
        row1.add(button1);

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCE5 Savat");
        row1.add(button2);
        rowList.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        KeyboardButton button3 = new KeyboardButton();
        button3.setText("AKSIYA");
        row2.add(button3);

        KeyboardButton button4 = new KeyboardButton();
        button4.setText("\uD83C\uDF5F\uD83C\uDF54\uD83E\uDD64 BARAKALI Maxi BOX");
        row2.add(button4);
        rowList.add(row2);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton button5 = new KeyboardButton();
        button5.setText("\uD83E\uDD6A Klab-Sendvich");
        row3.add(button5);

        KeyboardButton button6 = new KeyboardButton();
        button6.setText("\uD83C\uDF2F Lavash");
        row3.add(button6);
        rowList.add(row3);

        KeyboardRow row4 = new KeyboardRow();
        KeyboardButton button7 = new KeyboardButton();
        button7.setText("\uD83C\uDF2E Shaurma");
        row4.add(button7);

        KeyboardButton button8 = new KeyboardButton();
        button8.setText("\uD83C\uDF54 Burger");
        row4.add(button8);
        rowList.add(row4);

        KeyboardRow row5 = new KeyboardRow();
        KeyboardButton button9 = new KeyboardButton();
        button9.setText("\uD83C\uDF71 Donar kebab");
        row5.add(button9);

        KeyboardButton button10 = new KeyboardButton();
        button10.setText("\uD83C\uDF2D Hot dog");
        row5.add(button10);
        rowList.add(row5);

        KeyboardRow row6 = new KeyboardRow();
        KeyboardButton button11 = new KeyboardButton();
        button11.setText("\uD83C\uDF5F Gazaklar");
        row6.add(button11);

        KeyboardButton button12 = new KeyboardButton();
        button12.setText("\uD83C\uDF5A Tamaddilar");
        row6.add(button12);
        rowList.add(row6);

        KeyboardRow row7 = new KeyboardRow();
        KeyboardButton button13 = new KeyboardButton();
        button13.setText("\uD83C\uDF70 Desertlar");
        row7.add(button13);

        KeyboardButton button14 = new KeyboardButton();
        button14.setText("\uD83E\uDD64 Ichimliklar");
        row7.add(button14);
        rowList.add(row7);

        KeyboardRow row8 = new KeyboardRow();
        KeyboardButton button15 = new KeyboardButton();
        button15.setText("\uD83E\uDD6B Souslar");
        row8.add(button15);
        rowList.add(row8);


        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage gazaklar(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83C\uDF5FGazaklar\n" +
                "Mahsulotni tanlang:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        button = new KeyboardButton();
        button.setText("\uD83D\uDCE5 Savat");
        row.add(button);
        rowList.add(row);
        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Kartoshka fri");
        row.add(button);
        button = new KeyboardButton();
        button.setText("Naggetslar");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage tamaddilar(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83C\uDF5ATamaddilar\n" +
                "Mahsulotni tanlang:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        button = new KeyboardButton();
        button.setText("\uD83D\uDCE5 Savat");
        row.add(button);
        rowList.add(row);
        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Guruch");
        row.add(button);
        button = new KeyboardButton();
        button.setText("Salat");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage desertlar(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83C\uDF70Desertlar\n" +
                "Mahsulotni tanlang:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        button = new KeyboardButton();
        button.setText("\uD83D\uDCE5 Savat");
        row.add(button);
        rowList.add(row);
        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Tiramisu");
        row.add(button);
        button = new KeyboardButton();
        button.setText("Brauni");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage ichimliklar(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83E\uDD64Ichimliklar\n" +
                "Mahsulotni tanlang:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        button = new KeyboardButton();
        button.setText("\uD83D\uDCE5 Savat");
        row.add(button);
        rowList.add(row);
        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Coca Cola");
        row.add(button);
        button = new KeyboardButton();
        button.setText("Fanta");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }
    public SendMessage souslar(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83E\uDD6BSouslar\n" +
                "Mahsulotni tanlang:");

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button = new KeyboardButton();
        button.setText("⬅\uFE0F Orqaga");
        row.add(button);
        button = new KeyboardButton();
        button.setText("\uD83D\uDCE5 Savat");
        row.add(button);
        rowList.add(row);
        row = new KeyboardRow();
        button = new KeyboardButton();
        button.setText("Ketchup");
        row.add(button);
        button = new KeyboardButton();
        button.setText("Pishloqli sous");
        row.add(button);
        rowList.add(row);

        replyKeyboardMarkup.setKeyboard(rowList);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        return sendMessage;
    }

    //Maxi Box
    int iMaxiBox = 1;
    public SendPhoto maxiBox(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxi%20box%20maxway&imgurl=https%3A%2F%2Favatars.mds.yandex.net%2Fget-sprav-products%2F13059590%2F2a0000018f57c722278cba4efe6dbc6d6163%2FM_height&imgrefurl=https%3A%2F%2Fyandex.com%2Fmaps%2Forg%2Fmax_way%2F82469909697%2F&docid=6_4r633CMG2MuM&tbnid=XTyRovnF953DxM&vet=12ahUKEwj4uf-M1-CJAxUgU1UIHZ0BE6UQM3oECHMQAA..i&w=400&h=300&hcb=2&ved=2ahUKEwj4uf-M1-CJAxUgU1UIHZ0BE6UQM3oECHMQAA"));
        sendPhoto.setCaption("Maxi BOX Traditsiya \n" +
                "Original sendvich, kartoshka fri, 0,4 l coca cola, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Maxi BOX Traditsiya 45 000 x 1 = 45 000\n" +
                "\n" +
                "Umumiy: 45 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusMaxiBox");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneMaxiBox");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusMaxiBox");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup maxiBoxPlyus(Long chatId){

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxi%20box%20maxway&imgurl=https%3A%2F%2Favatars.mds.yandex.net%2Fget-sprav-products%2F13059590%2F2a0000018f57c722278cba4efe6dbc6d6163%2FM_height&imgrefurl=https%3A%2F%2Fyandex.com%2Fmaps%2Forg%2Fmax_way%2F82469909697%2F&docid=6_4r633CMG2MuM&tbnid=XTyRovnF953DxM&vet=12ahUKEwj4uf-M1-CJAxUgU1UIHZ0BE6UQM3oECHMQAA..i&w=400&h=300&hcb=2&ved=2ahUKEwj4uf-M1-CJAxUgU1UIHZ0BE6UQM3oECHMQAA"));
        sendPhoto.setCaption("Maxi BOX Traditsiya \n" +
                "Original sendvich, kartoshka fri, 0,4 l coca cola, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Maxi BOX Traditsiya 45 000 x 1 = 45 000\n" +
                "\n" +
                "Umumiy: 45 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusMaxiBox");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iMaxiBox));
        button1.setCallbackData("OneMaxiBox");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusMaxiBox");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup maxiBoxMinus(Long chatId){
        if (iMaxiBox>1){
            --iMaxiBox;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxi%20box%20maxway&imgurl=https%3A%2F%2Favatars.mds.yandex.net%2Fget-sprav-products%2F13059590%2F2a0000018f57c722278cba4efe6dbc6d6163%2FM_height&imgrefurl=https%3A%2F%2Fyandex.com%2Fmaps%2Forg%2Fmax_way%2F82469909697%2F&docid=6_4r633CMG2MuM&tbnid=XTyRovnF953DxM&vet=12ahUKEwj4uf-M1-CJAxUgU1UIHZ0BE6UQM3oECHMQAA..i&w=400&h=300&hcb=2&ved=2ahUKEwj4uf-M1-CJAxUgU1UIHZ0BE6UQM3oECHMQAA"));
        sendPhoto.setCaption("Maxi BOX Traditsiya \n" +
                "Original sendvich, kartoshka fri, 0,4 l coca cola, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Maxi BOX Traditsiya 45 000 x 1 = 45 000\n" +
                "\n" +
                "Umumiy: 45 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusMaxiBox");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iMaxiBox));
        button1.setCallbackData("OneMaxiBox");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusMaxiBox");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Aksiya
    int iAksiya =1;
    public SendPhoto aksiyam(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F4e201550-8df1-41a7-be2c-b32b3ca479e4&w=1920&q=75"));
        sendPhoto.setCaption("Tasty klab aksiyasi \n" +
                "Issiq yoki to'yimli! Yangi Tasty Klab sendvichini tatib ko'ring va o'zingiz tanlagan isituvchi qahva yoki kartoshka fri sovg'asini oling!!! \n" +
                "\n" +
                "Tasty klab aksiyasi 30 000 x 1 = 30 000\n" +
                "\n" +
                "Umumiy: 30 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusAksiya");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneAksiya");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusAksiya");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup aksiyaPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F4e201550-8df1-41a7-be2c-b32b3ca479e4&w=1920&q=75"));
        sendPhoto.setCaption("Tasty klab aksiyasi \n" +
                "Issiq yoki to'yimli! Yangi Tasty Klab sendvichini tatib ko'ring va o'zingiz tanlagan isituvchi qahva yoki kartoshka fri sovg'asini oling!!! \n" +
                "\n" +
                "Tasty klab aksiyasi 30 000 x 1 = 30 000\n" +
                "\n" +
                "Umumiy: 30 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusAksiya");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iAksiya));
        button1.setCallbackData("OneAksiya");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusAksiya");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup aksiyaMinus(Long chatId){
        if (iAksiya>1){
            --iAksiya;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F4e201550-8df1-41a7-be2c-b32b3ca479e4&w=1920&q=75"));
        sendPhoto.setCaption("Tasty klab aksiyasi \n" +
                "Issiq yoki to'yimli! Yangi Tasty Klab sendvichini tatib ko'ring va o'zingiz tanlagan isituvchi qahva yoki kartoshka fri sovg'asini oling!!! \n" +
                "\n" +
                "Tasty klab aksiyasi 30 000 x 1 = 30 000\n" +
                "\n" +
                "Umumiy: 30 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusAksiya");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iAksiya));
        button1.setCallbackData("OneAksiya");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusAksiya");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Klab Sendwich
    int iKlabSendwich = 1;
    public SendPhoto klabSendwich(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20klab%20sandwich&imgurl=https%3A%2F%2Favatars.mds.yandex.net%2Fget-sprav-products%2F9896919%2F2a0000018f57cba6fafe0864b32930536630%2FM_height&imgrefurl=https%3A%2F%2Fyandex.uz%2Fmaps%2Forg%2F200801115433%2F&docid=c57KKK5nAqUUdM&tbnid=GBR0RmOwjWeDhM&vet=12ahUKEwjCs87l3uCJAxWoIRAIHTCRO_sQM3oECBYQAA..i&w=400&h=300&hcb=2&ved=2ahUKEwjCs87l3uCJAxWoIRAIHTCRO_sQM3oECBYQAA"));
        sendPhoto.setCaption("Klab sendvich \n" +
                "Original sendvich, kartoshka fri, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Klab sendvich 38 000 x 1 = 38 000\n" +
                "\n" +
                "Umumiy: 38 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusKlabSendwich");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneKlabSendwich");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusKlabSendwich");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup klabSendwichPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20klab%20sandwich&imgurl=https%3A%2F%2Favatars.mds.yandex.net%2Fget-sprav-products%2F9896919%2F2a0000018f57cba6fafe0864b32930536630%2FM_height&imgrefurl=https%3A%2F%2Fyandex.uz%2Fmaps%2Forg%2F200801115433%2F&docid=c57KKK5nAqUUdM&tbnid=GBR0RmOwjWeDhM&vet=12ahUKEwjCs87l3uCJAxWoIRAIHTCRO_sQM3oECBYQAA..i&w=400&h=300&hcb=2&ved=2ahUKEwjCs87l3uCJAxWoIRAIHTCRO_sQM3oECBYQAA"));
        sendPhoto.setCaption("Klab sendvich \n" +
                "Original sendvich, kartoshka fri, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Klab sendvich 38 000 x 1 = 38 000\n" +
                "\n" +
                "Umumiy: 38 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusKlabSendwich");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iKlabSendwich));
        button1.setCallbackData("OneKlabSendwich");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusKlabSendwich");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup klabSendwichMinus(Long chatId){
        if (iKlabSendwich>1){
            --iKlabSendwich;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20klab%20sandwich&imgurl=https%3A%2F%2Favatars.mds.yandex.net%2Fget-sprav-products%2F9896919%2F2a0000018f57cba6fafe0864b32930536630%2FM_height&imgrefurl=https%3A%2F%2Fyandex.uz%2Fmaps%2Forg%2F200801115433%2F&docid=c57KKK5nAqUUdM&tbnid=GBR0RmOwjWeDhM&vet=12ahUKEwjCs87l3uCJAxWoIRAIHTCRO_sQM3oECBYQAA..i&w=400&h=300&hcb=2&ved=2ahUKEwjCs87l3uCJAxWoIRAIHTCRO_sQM3oECBYQAA"));
        sendPhoto.setCaption("Klab sendvich \n" +
                "Original sendvich, kartoshka fri, tanlash uchun sous\n" +
                " \n" +
                "\n" +
                "Klab sendvich 38 000 x 1 = 38 000\n" +
                "\n" +
                "Umumiy: 38 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusKlabSendwich");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iKlabSendwich));
        button1.setCallbackData("OneKlabSendwich");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusKlabSendwich");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Lavash
    int iLavash = 1;
    public SendPhoto lavash(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20lavash&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1449731305213044&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fishtaxa-ochuvchi-lavash-yumshoqqina-tovuq-bolakchalari-bilan-kunning-istalgan-va%2F1449731351879706%2F&docid=FHADKKq-dCHIxM&tbnid=TE1twTtqMcYqIM&vet=12ahUKEwiGh8KD4-CJAxXaPxAIHeeVInsQM3oECG8QAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwiGh8KD4-CJAxXaPxAIHeeVInsQM3oECG8QAA"));
        sendPhoto.setCaption("Lavash standart klassik \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chipslar, pomidor sousi, mayonez \n" +
                "\n" +
                "Lavash standart klassik 32 000 x 1 = 32 000\n" +
                "Umumiy: 32 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusLavash");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneLavash");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusLavash");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup lavashPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20lavash&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1449731305213044&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fishtaxa-ochuvchi-lavash-yumshoqqina-tovuq-bolakchalari-bilan-kunning-istalgan-va%2F1449731351879706%2F&docid=FHADKKq-dCHIxM&tbnid=TE1twTtqMcYqIM&vet=12ahUKEwiGh8KD4-CJAxXaPxAIHeeVInsQM3oECG8QAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwiGh8KD4-CJAxXaPxAIHeeVInsQM3oECG8QAA"));
        sendPhoto.setCaption("Lavash standart klassik \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chipslar, pomidor sousi, mayonez \n" +
                "\n" +
                "Lavash standart klassik 32 000 x 1 = 32 000\n" +
                "Umumiy: 32 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusLavash");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iLavash));
        button1.setCallbackData("OneLavash");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusLavash");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup lavashMinus(Long chatId){
        if (iLavash>1){
            --iLavash;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20lavash&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1449731305213044&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fishtaxa-ochuvchi-lavash-yumshoqqina-tovuq-bolakchalari-bilan-kunning-istalgan-va%2F1449731351879706%2F&docid=FHADKKq-dCHIxM&tbnid=TE1twTtqMcYqIM&vet=12ahUKEwiGh8KD4-CJAxXaPxAIHeeVInsQM3oECG8QAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwiGh8KD4-CJAxXaPxAIHeeVInsQM3oECG8QAA"));
        sendPhoto.setCaption("Lavash standart klassik \n" +
                "Lavash xamiri, mol go'shti-donar, pomidor, chipslar, pomidor sousi, mayonez \n" +
                "\n" +
                "Lavash standart klassik 32 000 x 1 = 32 000\n" +
                "Umumiy: 32 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusLavash");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iLavash));
        button1.setCallbackData("OneLavash");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusLavash");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Shaurma
    int iShaurma = 1;
    public SendPhoto shaurma(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20shaurma&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1619818668204306&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fmazali-shaurma-yaxshi-kayfiyat-71-200-5400-tmemaxwayuz_bot%25D0%25B2%25D0%25BA%25D1%2583%25D1%2581%25D0%25BD%25D0%25B0%25D1%258F-%25D1%2588%25D0%25B0%25D1%2583%25D1%2580%25D0%25BC%25D0%25B0-%25D1%2585%25D0%25BE%25D1%2580%25D0%25BE%25D1%2588%25D0%25B5%25D0%25B5%2F1619818754870964%2F&docid=pIUXpImB327kzM&tbnid=qjb_9aTn43ETVM&vet=12ahUKEwjr-9mx4-CJAxVCKBAIHdoaBBYQM3oECBwQAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwjr-9mx4-CJAxVCKBAIHdoaBBYQM3oECBwQAA"));
        sendPhoto.setCaption("Shaurma \n" +
                "Donor bulochka, mol go'shti-donar, yangi bodring, pomidor, pomidor sousi \n" +
                "\n" +
                "Shaurma 29 000 x 1 = 29 000\n" +
                "Umumiy: 29 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusShaurma");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneShaurma");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusShaurma");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup shaurmaPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20shaurma&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1619818668204306&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fmazali-shaurma-yaxshi-kayfiyat-71-200-5400-tmemaxwayuz_bot%25D0%25B2%25D0%25BA%25D1%2583%25D1%2581%25D0%25BD%25D0%25B0%25D1%258F-%25D1%2588%25D0%25B0%25D1%2583%25D1%2580%25D0%25BC%25D0%25B0-%25D1%2585%25D0%25BE%25D1%2580%25D0%25BE%25D1%2588%25D0%25B5%25D0%25B5%2F1619818754870964%2F&docid=pIUXpImB327kzM&tbnid=qjb_9aTn43ETVM&vet=12ahUKEwjr-9mx4-CJAxVCKBAIHdoaBBYQM3oECBwQAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwjr-9mx4-CJAxVCKBAIHdoaBBYQM3oECBwQAA"));
        sendPhoto.setCaption("Shaurma \n" +
                "Donor bulochka, mol go'shti-donar, yangi bodring, pomidor, pomidor sousi \n" +
                "\n" +
                "Shaurma 29 000 x 1 = 29 000\n" +
                "Umumiy: 29 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusShaurma");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iShaurma));
        button1.setCallbackData("OneShaurma");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusShaurma");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup shaurmaMinus(Long chatId){
        if (iShaurma>1){
            --iShaurma;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20shaurma&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1619818668204306&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fmazali-shaurma-yaxshi-kayfiyat-71-200-5400-tmemaxwayuz_bot%25D0%25B2%25D0%25BA%25D1%2583%25D1%2581%25D0%25BD%25D0%25B0%25D1%258F-%25D1%2588%25D0%25B0%25D1%2583%25D1%2580%25D0%25BC%25D0%25B0-%25D1%2585%25D0%25BE%25D1%2580%25D0%25BE%25D1%2588%25D0%25B5%25D0%25B5%2F1619818754870964%2F&docid=pIUXpImB327kzM&tbnid=qjb_9aTn43ETVM&vet=12ahUKEwjr-9mx4-CJAxVCKBAIHdoaBBYQM3oECBwQAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwjr-9mx4-CJAxVCKBAIHdoaBBYQM3oECBwQAA"));
        sendPhoto.setCaption("Shaurma \n" +
                "Donor bulochka, mol go'shti-donar, yangi bodring, pomidor, pomidor sousi \n" +
                "\n" +
                "Shaurma 29 000 x 1 = 29 000\n" +
                "Umumiy: 29 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusShaurma");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iShaurma));
        button1.setCallbackData("OneShaurma");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusShaurma");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Burger
    int iBurger = 1;
    public SendPhoto burger(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20burger&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1539230089596498&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fmaksburger-maksimal-lazzat-uchunyetkazib-berish-narxi-tushirildi-demak-mazali-bu%2F1539230132929827%2F&docid=8ZNsUfdsK0lA5M&tbnid=LQBL45smavmWPM&vet=12ahUKEwjnu-uB5OCJAxXQHXcKHXcHHqEQM3oECBgQAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwjnu-uB5OCJAxXQHXcKHXcHHqEQM3oECBgQAA"));
        sendPhoto.setCaption("Gamburger \n" +
                "Burger bulochkasi, tuzlangan bodring, pomidor, go'shtli Patti, qizil piyoz, aysberg, Burger sousi\n" +
                " \n" +
                "\n" +
                "Gamburger 25 000 x 1 = 25 000\n" +
                "Umumiy: 25 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusBurger");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneBurger");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusBurger");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup burgerPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20burger&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1539230089596498&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fmaksburger-maksimal-lazzat-uchunyetkazib-berish-narxi-tushirildi-demak-mazali-bu%2F1539230132929827%2F&docid=8ZNsUfdsK0lA5M&tbnid=LQBL45smavmWPM&vet=12ahUKEwjnu-uB5OCJAxXQHXcKHXcHHqEQM3oECBgQAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwjnu-uB5OCJAxXQHXcKHXcHHqEQM3oECBgQAA"));
        sendPhoto.setCaption("Gamburger \n" +
                "Burger bulochkasi, tuzlangan bodring, pomidor, go'shtli Patti, qizil piyoz, aysberg, Burger sousi\n" +
                " \n" +
                "\n" +
                "Gamburger 25 000 x 1 = 25 000\n" +
                "Umumiy: 25 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusBurger");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iBurger));
        button1.setCallbackData("OneBurger");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusBurger");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup burgerMinus(Long chatId){
        if (iBurger>1){
            --iBurger;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://www.google.com/imgres?q=maxway%20burger&imgurl=https%3A%2F%2Flookaside.fbsbx.com%2Flookaside%2Fcrawler%2Fmedia%2F%3Fmedia_id%3D1539230089596498&imgrefurl=https%3A%2F%2Fwww.facebook.com%2Fmaxway.uzb%2Fposts%2Fmaksburger-maksimal-lazzat-uchunyetkazib-berish-narxi-tushirildi-demak-mazali-bu%2F1539230132929827%2F&docid=8ZNsUfdsK0lA5M&tbnid=LQBL45smavmWPM&vet=12ahUKEwjnu-uB5OCJAxXQHXcKHXcHHqEQM3oECBgQAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwjnu-uB5OCJAxXQHXcKHXcHHqEQM3oECBgQAA"));
        sendPhoto.setCaption("Gamburger \n" +
                "Burger bulochkasi, tuzlangan bodring, pomidor, go'shtli Patti, qizil piyoz, aysberg, Burger sousi\n" +
                " \n" +
                "\n" +
                "Gamburger 25 000 x 1 = 25 000\n" +
                "Umumiy: 25 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusBurger");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iBurger));
        button1.setCallbackData("OneBurger");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusBurger");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Donar Kebab
    int iDonar = 1;
    public SendPhoto donarKebab(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F561cf6a1-3f19-479d-b057-04c11ee0b891&w=1920&q=75"));
        sendPhoto.setCaption("Donar kebab  \n" +
                "Mol go'shti donari-go'sht, makkajo'xori bilan guruch, kartoshka fri, qizil karam salati, pomidor sous\n" +
                " \n" +
                "\n" +
                "Donar kebab  46 000 x 1 = 46 000\n" +
                "Umumiy: 46 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusDonar");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneDonar");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusDonar");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup donarKebabPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F561cf6a1-3f19-479d-b057-04c11ee0b891&w=1920&q=75"));
        sendPhoto.setCaption("Donar kebab  \n" +
                "Mol go'shti donari-go'sht, makkajo'xori bilan guruch, kartoshka fri, qizil karam salati, pomidor sous\n" +
                " \n" +
                "\n" +
                "Donar kebab  46 000 x 1 = 46 000\n" +
                "Umumiy: 46 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusDonar");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iDonar));
        button1.setCallbackData("OneDonar");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusDonar");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup donarKebabMinus(Long chatId){
        if (iDonar>1){
            --iDonar;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F561cf6a1-3f19-479d-b057-04c11ee0b891&w=1920&q=75"));
        sendPhoto.setCaption("Donar kebab  \n" +
                "Mol go'shti donari-go'sht, makkajo'xori bilan guruch, kartoshka fri, qizil karam salati, pomidor sous\n" +
                " \n" +
                "\n" +
                "Donar kebab  46 000 x 1 = 46 000\n" +
                "Umumiy: 46 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusDonar");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iDonar));
        button1.setCallbackData("OneDonar");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusDonar");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Hot Dog
    int iHotDog =1;
    public SendPhoto hotDog(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd07386d0-4d92-4406-8c47-0ec0ff3123a3&w=1920&q=75"));
        sendPhoto.setCaption("Hot Dog \n" +
                "Hot-dog bulochkasi, Kanada sosiskasi, tuzlangan bodring, pomidor, ketchup va mayonez\n" +
                " \n" +
                "\n" +
                "Hot Dog 12 000 x 1 = 12 000\n" +
                "Umumiy: 12 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusHotDog");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneHotDog");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusHotDog");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup hotDogPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd07386d0-4d92-4406-8c47-0ec0ff3123a3&w=1920&q=75"));
        sendPhoto.setCaption("Hot Dog \n" +
                "Hot-dog bulochkasi, Kanada sosiskasi, tuzlangan bodring, pomidor, ketchup va mayonez\n" +
                " \n" +
                "\n" +
                "Hot Dog 12 000 x 1 = 12 000\n" +
                "Umumiy: 12 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusHotDog");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iHotDog));
        button1.setCallbackData("OneHotDog");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusHotDog");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup hotDogMinus(Long chatId){
        if (iHotDog>1){
            --iHotDog;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fd07386d0-4d92-4406-8c47-0ec0ff3123a3&w=1920&q=75"));
        sendPhoto.setCaption("Hot Dog \n" +
                "Hot-dog bulochkasi, Kanada sosiskasi, tuzlangan bodring, pomidor, ketchup va mayonez\n" +
                " \n" +
                "\n" +
                "Hot Dog 12 000 x 1 = 12 000\n" +
                "Umumiy: 12 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusHotDog");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iHotDog));
        button1.setCallbackData("OneHotDog");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusHotDog");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Kartoshka Fri
    int iFri =1;
    public SendPhoto kartoshkaFri(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe238451f-6851-4554-8225-0be60c7e81c5&w=640&q=75"));
        sendPhoto.setCaption("Kartoshka fri katta \n" +
                " \n" +
                "\n" +
                "Kartoshka fri katta 18 000 x 1 = 18 000\n" +
                "Umumiy: 18 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusFri");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneFri");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusFri");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup friPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe238451f-6851-4554-8225-0be60c7e81c5&w=640&q=75"));
        sendPhoto.setCaption("Kartoshka fri katta \n" +
                " \n" +
                "\n" +
                "Kartoshka fri katta 18 000 x 1 = 18 000\n" +
                "Umumiy: 18 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusFri");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iFri));
        button1.setCallbackData("OneFri");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusFri");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup friMinus(Long chatId){
        if (iFri>1){
            --iFri;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fe238451f-6851-4554-8225-0be60c7e81c5&w=640&q=75"));
        sendPhoto.setCaption("Kartoshka fri katta \n" +
                " \n" +
                "\n" +
                "Kartoshka fri katta 18 000 x 1 = 18 000\n" +
                "Umumiy: 18 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusFri");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iFri));
        button1.setCallbackData("OneFri");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusFri");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Naggetslar
    int iNaggets =1;
    public SendPhoto naggets(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fb081f071-b76b-4ce3-a85c-8b05c5e31ffb&w=640&q=75"));
        sendPhoto.setCaption("Naggetslar  10 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar  10 dona 23 000 x 1 = 23 000\n" +
                "Umumiy: 23 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusNaggets");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneNaggets");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusNaggets");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup naggetsPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fb081f071-b76b-4ce3-a85c-8b05c5e31ffb&w=640&q=75"));
        sendPhoto.setCaption("Naggetslar  10 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar  10 dona 23 000 x 1 = 23 000\n" +
                "Umumiy: 23 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusNaggets");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iNaggets));
        button1.setCallbackData("OneNaggets");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusNaggets");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup naggetsMinus(Long chatId){
        if (iNaggets>1){
            --iNaggets;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fb081f071-b76b-4ce3-a85c-8b05c5e31ffb&w=640&q=75"));
        sendPhoto.setCaption("Naggetslar  10 dona \n" +
                " \n" +
                "\n" +
                "Naggetslar  10 dona 23 000 x 1 = 23 000\n" +
                "Umumiy: 23 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusNaggets");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iNaggets));
        button1.setCallbackData("OneNaggets");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusNaggets");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Guruch
    int iGuruch =1;
    public SendPhoto guruch(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1c55ac0a-6436-4b1d-ada7-8377b6871e53&w=640&q=75"));
        sendPhoto.setCaption("Guruch \n" +
                "Shirin makkajo'xori bilan pishirilgan lazer guruch\n" +
                " \n" +
                "\n" +
                "Guruch 7 000 x 1 = 7 000\n" +
                "Umumiy: 7 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusGuruch");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneGuruch");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusGuruch");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup guruchPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1c55ac0a-6436-4b1d-ada7-8377b6871e53&w=1920&q=75"));
        sendPhoto.setCaption("Guruch \n" +
                "Shirin makkajo'xori bilan pishirilgan lazer guruch\n" +
                " \n" +
                "\n" +
                "Guruch 7 000 x 1 = 7 000\n" +
                "Umumiy: 7 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusGuruch");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iGuruch));
        button1.setCallbackData("OneGuruch");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusGuruch");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup guruchMinus(Long chatId){
        if (iGuruch>1){
            --iGuruch;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F1c55ac0a-6436-4b1d-ada7-8377b6871e53&w=1920&q=75"));
        sendPhoto.setCaption("Guruch \n" +
                "Shirin makkajo'xori bilan pishirilgan lazer guruch\n" +
                " \n" +
                "\n" +
                "Guruch 7 000 x 1 = 7 000\n" +
                "Umumiy: 7 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusGuruch");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iGuruch));
        button1.setCallbackData("OneGuruch");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusGuruch");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Salad
    int iSalad = 1;
    public SendPhoto salad(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fefff60bd-15c2-4e6c-9f1b-2a0eea692af7&w=1920&q=75"));
        sendPhoto.setCaption("Salat \n" +
                "Salat qizil karam aralashmasi\n" +
                " \n" +
                "\n" +
                "Salat 7 000 x 1 = 7 000\n" +
                "Umumiy: 7 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusSalad");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneSalad");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusSalad");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup saladPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fefff60bd-15c2-4e6c-9f1b-2a0eea692af7&w=1920&q=75"));
        sendPhoto.setCaption("Salat \n" +
                "Salat qizil karam aralashmasi\n" +
                " \n" +
                "\n" +
                "Salat 7 000 x 1 = 7 000\n" +
                "Umumiy: 7 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusSalad");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iSalad));
        button1.setCallbackData("OneSalad");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusSalad");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup saladMinus(Long chatId){
        if (iSalad>1){
            --iSalad;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fefff60bd-15c2-4e6c-9f1b-2a0eea692af7&w=1920&q=75"));
        sendPhoto.setCaption("Salat \n" +
                "Salat qizil karam aralashmasi\n" +
                " \n" +
                "\n" +
                "Salat 7 000 x 1 = 7 000\n" +
                "Umumiy: 7 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusSalad");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iSalad));
        button1.setCallbackData("OneSalad");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusSalad");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Tiramusu
    int iTiramisu = 1;
    public SendPhoto tiramisu(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fdd3eb9ef-b9e6-48ac-824a-66cfd0f39913&w=640&q=75"));
        sendPhoto.setCaption("Tiramisu \n" +
                "Savoyardi pechene, mascarpone, qahva\n" +
                " \n" +
                "\n" +
                "Tiramisu 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusTiramisu");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneTiramisu");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusTiramisu");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup tiramisuPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fdd3eb9ef-b9e6-48ac-824a-66cfd0f39913&w=640&q=75"));
        sendPhoto.setCaption("Tiramisu \n" +
                "Savoyardi pechene, mascarpone, qahva\n" +
                " \n" +
                "\n" +
                "Tiramisu 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusTiramisu");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iTiramisu));
        button1.setCallbackData("OneTiramisu");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusTiramisu");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup tiramisuMinus(Long chatId){
        if (iTiramisu>1){
            --iTiramisu;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Fdd3eb9ef-b9e6-48ac-824a-66cfd0f39913&w=640&q=75"));
        sendPhoto.setCaption("Tiramisu \n" +
                "Savoyardi pechene, mascarpone, qahva\n" +
                " \n" +
                "\n" +
                "Tiramisu 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusTiramisu");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iTiramisu));
        button1.setCallbackData("OneTiramisu");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusTiramisu");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Brauni
    int iBrauni = 1;
    public SendPhoto brauni(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Febf7f8ee-0181-4294-9be8-f9241e3cff08&w=640&q=75"));
        sendPhoto.setCaption("Brauni \n" +
                "Qora shokolad, yong'oq va shokoladli pechene\n" +
                " \n" +
                "\n" +
                "Brauni 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusBrauni");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneBrauni");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusBrauni");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup brauniPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Febf7f8ee-0181-4294-9be8-f9241e3cff08&w=640&q=75"));
        sendPhoto.setCaption("Brauni \n" +
                "Qora shokolad, yong'oq va shokoladli pechene\n" +
                " \n" +
                "\n" +
                "Brauni 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusBrauni");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iBrauni));
        button1.setCallbackData("OneBrauni");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusBrauni");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup brauniMinus(Long chatId){
        if (iBrauni>1){
            --iBrauni;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Febf7f8ee-0181-4294-9be8-f9241e3cff08&w=640&q=75"));
        sendPhoto.setCaption("Brauni \n" +
                "Qora shokolad, yong'oq va shokoladli pechene\n" +
                " \n" +
                "\n" +
                "Brauni 22 000 x 1 = 22 000\n" +
                "Umumiy: 22 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusBrauni");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iBrauni));
        button1.setCallbackData("OneBrauni");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusBrauni");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Coca Cola
    int iCola = 1;
    public SendPhoto cocaCola(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Feefc67f4-9e14-4635-a174-4c5c6483744f&w=640&q=75"));
        sendPhoto.setCaption("Coca Cola  1.5 L \n" +
                "Coca Cola  1.5 L \n" +
                "\n" +
                "Coca Cola  1.5 L 19 000 x 1 = 19 000\n" +
                "Umumiy: 19 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusCocaCola");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneCocaCola");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusCocaCola");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup cocaColaPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Feefc67f4-9e14-4635-a174-4c5c6483744f&w=640&q=75"));
            sendPhoto.setCaption("Coca Cola  1.5 L \n" +
                    "Coca Cola  1.5 L \n" +
                    "\n" +
                    "Coca Cola  1.5 L 19 000 x 1 = 19 000\n" +
                    "Umumiy: 19 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusCocaCola");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iCola));
        button1.setCallbackData("OneCocaCola");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusCocaCola");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup cocaColaMinus(Long chatId){
        if (iCola>1){
            --iCola;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2Feefc67f4-9e14-4635-a174-4c5c6483744f&w=640&q=75"));
        sendPhoto.setCaption("Coca Cola  1.5 L \n" +
                "Coca Cola  1.5 L \n" +
                "\n" +
                "Coca Cola  1.5 L 19 000 x 1 = 19 000\n" +
                "Umumiy: 19 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusCocaCola");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iCola));
        button1.setCallbackData("OneCocaCola");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusCocaCola");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Fanta
    int iFanta = 1;
    public SendPhoto fanta(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F9ebe8f81-c8cf-44da-9f62-8f65a65f4c3a&w=640&q=75"));
        sendPhoto.setCaption("Fanta 500 ml \n" +
                " \n" +
                "\n" +
                "Fanta 500 ml 10 000 x 1 = 10 000");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusFanta");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneFanta");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusFanta");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup fantaPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F9ebe8f81-c8cf-44da-9f62-8f65a65f4c3a&w=640&q=75"));
        sendPhoto.setCaption("Fanta 500 ml \n" +
                " \n" +
                "\n" +
                "Fanta 500 ml 10 000 x 1 = 10 000");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusFanta");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iFanta));
        button1.setCallbackData("OneFanta");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusFanta");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup fantaMinus(Long chatId){
        if (iFanta>1){
            --iFanta;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F9ebe8f81-c8cf-44da-9f62-8f65a65f4c3a&w=640&q=75"));
        sendPhoto.setCaption("Fanta 500 ml \n" +
                " \n" +
                "\n" +
                "Fanta 500 ml 10 000 x 1 = 10 000");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusFanta");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iFanta));
        button1.setCallbackData("OneFanta");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusFanta");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Ketchup
    int iKetchup = 1;
    public SendPhoto ketchup(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F7602a40e-d2ee-495e-8543-1a505f97fc21&w=640&q=75"));
        sendPhoto.setCaption("Ketchup \n" +
                " \n" +
                "\n" +
                "Ketchup 3 000 x 1 = 3 000\n" +
                "Umumiy: 3 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusKetchup");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OneKetchup");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusKetchup");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup ketchupPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F7602a40e-d2ee-495e-8543-1a505f97fc21&w=640&q=75"));
        sendPhoto.setCaption("Ketchup \n" +
                " \n" +
                "\n" +
                "Ketchup 3 000 x 1 = 3 000\n" +
                "Umumiy: 3 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusKetchup");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iKetchup));
        button1.setCallbackData("OneKetchup");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusKetchup");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup ketchupMinus(Long chatId){
        if (iKetchup>1){
            --iKetchup;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F7602a40e-d2ee-495e-8543-1a505f97fc21&w=640&q=75"));
        sendPhoto.setCaption("Ketchup \n" +
                " \n" +
                "\n" +
                "Ketchup 3 000 x 1 = 3 000\n" +
                "Umumiy: 3 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusKetchup");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iKetchup));
        button1.setCallbackData("OneKetchup");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusKetchup");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    //Pishloqli sous
    int iPishloqliSous = 1;
    public SendPhoto pishloqliSous(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F09d6df13-155c-4371-9189-87402a4c2c3f&w=640&q=75"));
        sendPhoto.setCaption("Pishloqli sous \n" +
                " \n" +
                "\n" +
                "Pishloqli sous 3 000 x 1 = 3 000\n" +
                "Umumiy: 3 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusPishloqliSous");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("OnePishloqliSous");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusPishloqliSous");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return sendPhoto;



    }
    public InlineKeyboardMarkup pishloqliSousPlus(Long chatId){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F09d6df13-155c-4371-9189-87402a4c2c3f&w=640&q=75"));
        sendPhoto.setCaption("Pishloqli sous \n" +
                " \n" +
                "\n" +
                "Pishloqli sous 3 000 x 1 = 3 000\n" +
                "Umumiy: 3 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusPishloqliSous");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(++iPishloqliSous));
        button1.setCallbackData("OnePishloqliSous");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusPishloqliSous");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }
    public InlineKeyboardMarkup pishloqliSousMinus(Long chatId){
        if (iPishloqliSous>1){
            --iPishloqliSous;
        }
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile("https://maxway.uz/_next/image?url=https%3A%2F%2Fcdn.delever.uz%2Fdelever%2F09d6df13-155c-4371-9189-87402a4c2c3f&w=640&q=75"));
        sendPhoto.setCaption("Pishloqli sous \n" +
                " \n" +
                "\n" +
                "Pishloqli sous 3 000 x 1 = 3 000\n" +
                "Umumiy: 3 000 UZS");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> rowlist = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("➖");
        button.setCallbackData("MinusPishloqliSous");
        row.add(button);
        rowlist.add(row);
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(String.valueOf(iPishloqliSous));
        button1.setCallbackData("OnePishloqliSous");
        row.add(button1);
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("➕");
        button2.setCallbackData("PlusPishloqliSous");
        row.add(button2);

        inlineKeyboardMarkup.setKeyboard(rowlist);
        sendPhoto.setReplyMarkup(inlineKeyboardMarkup);
        return inlineKeyboardMarkup;



    }

    // Location
    public SendLocation beruniyLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.3445585);
        sendLocation.setLongitude(69.2019528);
        return sendLocation;
    }
    public SendLocation megaPlanetLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.3656562);
        sendLocation.setLongitude(69.2921098);
        return sendLocation;
    }
    public SendLocation aviasozlarLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.2908676);
        sendLocation.setLongitude(69.3396676);
        return sendLocation;
    }
    public SendLocation risoviyLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.2746847);
        sendLocation.setLongitude(69.3073936);
        return sendLocation;
    }
    public SendLocation sayramLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.274887);
        sendLocation.setLongitude(69.309431);
        return sendLocation;
    }
    public SendLocation maksimGorkiyLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.327058);
        sendLocation.setLongitude(69.329903);
        return sendLocation;
    }
    public SendLocation sergeliLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(41.226371);
        sendLocation.setLongitude(69.219904);
        return sendLocation;
    }
    public SendMessage beruniyText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY BERUNIY \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  улица Беруни, 47, Ташкент \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:  Метро Беруний \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 23:00");
        return sendMessage;
    }
    public SendMessage megaPlanetText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY MEGA PLANET \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  улица Ниязбек, 1 \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:  улица Ниязбек, 1 \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 03:00");
        return sendMessage;
    }
    public SendMessage aviasozlarText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY AVIASOZLAR \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  улица Авиасозлар, 23 \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:   \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 03:00");
        return sendMessage;
    }
    public SendMessage risoviyText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY RISOVIY \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  Узбекистан, Ташкент, Алтынкульская улица, 10 \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:  банкетный зал Тантана \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 03:00");
        return sendMessage;
    }
    public SendMessage sayramText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY SAYRAM \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  Узбекистан, Ташкент, улица Юнусота \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:  Ориентир: Рынок сайрам.  \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 03:00");
        return sendMessage;
    }
    public SendMessage maksimGorkiyText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY MAKSIM GORKIY \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  махалля Элобод \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:  Ориентир: Метро буюк ипак йули \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 01:00");
        return sendMessage;
    }
    public SendMessage sergeliText(Long chatId){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("\uD83D\uDCCD Filial:  MAX WAY SERGELI \n" +
                "                     \n" +
                "\uD83D\uDDFA Manzil:  Узбекистан, Ташкент, Сергелийский район, массив Сергели-VIIIА, 11 \n" +
                "                     \n" +
                "\uD83C\uDFE2 Orientir:  Ориентир: Сергели Дехкон Бозори \n" +
                "                     \n" +
                "☎\uFE0F Telefon raqami:  +998712005400\n" +
                "                     \n" +
                "\uD83D\uDD59 Ish vaqti : 10:00 - 03:00");
        return sendMessage;
    }


    public static void saveExcel(String firstName, String lastName, Long chatId, String text){
        XSSFWorkbook sheets = new XSSFWorkbook();

        XSSFSheet xssfSheet = sheets.createSheet("Data");
        XSSFRow row = xssfSheet.createRow(0);
        XSSFCellStyle cellStyle = sheets.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        XSSFCell cell = row.createCell(0, Cell.CELL_TYPE_STRING);
        cell.setCellValue("firstName");
        cell.setCellStyle(cellStyle);

        XSSFCell cell1 = row.createCell(1, Cell.CELL_TYPE_STRING);
        cell1.setCellValue("lastName");
        cell1.setCellStyle(cellStyle);

        XSSFCell cell2 = row.createCell(2, Cell.CELL_TYPE_STRING);
        cell2.setCellValue("chatId");
        cell2.setCellStyle(cellStyle);

        XSSFCell cell3 = row.createCell(3, Cell.CELL_TYPE_STRING);
        cell3.setCellValue("text");
        cell3.setCellStyle(cellStyle);

        int i=1;

        for (User use: userList){
            XSSFRow row1 = xssfSheet.createRow(i++);
            row1.createCell(0, Cell.CELL_TYPE_STRING).setCellValue(use.getFirstName());
            row1.createCell(1, Cell.CELL_TYPE_STRING).setCellValue(use.getLastName());
            row1.createCell(2, Cell.CELL_TYPE_NUMERIC).setCellValue(use.getChatId());
            row1.createCell(3, Cell.CELL_TYPE_STRING).setCellValue(use.getText());
        }

        try {
            sheets.write(new FileOutputStream("D:\\data_Maxway.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
