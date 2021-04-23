package Server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryFilesMSG {

   int num = 100;

   public static void writeHistoryMSGFile(String nickName, String str){

       String fileName = String.format("FilesHistoryMSG\\%s.msg", nickName);
       File file = new File(fileName);

       if (!file.exists()){
           try {
               file.createNewFile();

           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       try (BufferedWriter bufferedWriter = new BufferedWriter(
               new FileWriter(fileName, true)
       )){

           bufferedWriter.write(str);
           bufferedWriter.newLine();

           for (int i = 0; i < 200; i++) {
               bufferedWriter.write(str + " " + (i + 1));
               bufferedWriter.newLine();
           }

       } catch (Exception e){
           e.printStackTrace();
       }
   }

   public static List<String> readHistoryMSGFile(String nickName){

       int num = 100;

       List<String> stringList = null;
       String fileName = String.format("FilesHistoryMSG\\%s.msg", nickName);

       if (new File(fileName).exists()){

           try (BufferedReader bufferedReader = new BufferedReader(
                   new FileReader(fileName)
           )){

               String line;
               stringList = new ArrayList<>();

               while ((line = bufferedReader.readLine()) != null) {
                   stringList.add(line);

               }

               int size = stringList.size();

               if (size > num) {
                   stringList = stringList.subList(size - num, size);

               }

           } catch (Exception e){
               e.printStackTrace();

           }
       }
       return stringList;
   }
}



_________________________________________________________________

//Отправка истории сообщений авториз. пользователю.
if ((history = HistoryFilesMSG.readHistoryMSGFile(nick)) != null){
   for (int i = 0; i < history.size(); i++) {
       sendMSG(history.get(i));
   }
}


____________________________________________________________________
//    Метод осуществляет отправку сообщения всем пользователям.
   public void broadcastMSG(ClientHandler from, String str){

       for (ClientHandler c: users) {

//            Проверка на наличие nickname (получателя/отправителя) в blacklist (отправителя/получателя).
           if (!c.checkBlackList(from.getNickname())
                   && !from.checkBlackList(c.getNickname())){
               HistoryFilesMSG.writeHistoryMSGFile(c.getNickname(), str);
//                AuthSetvice.historyMsgAdd(c.getNickname(), str);
               c.sendMSG(str);
           }
       }
   }

//      Отправка приватных сообщений.
   public void privateMSG(String nickOut, String nickIn, String str){

       for (ClientHandler c: users) {
//            Сообщение отправляется только двум пользователямю.
           if (c.getNickname().equals(nickOut) || c.getNickname().equals(nickIn)) {

//                Проверка наличия nickname отправителя в blacklist получателя.
               if (!c.checkBlackList(nickOut)){
                   HistoryFilesMSG.writeHistoryMSGFile(c.getNickname(), nickOut + ": [send for " + nickIn + "] msg: " + str);
//                    AuthSetvice.historyMsgAdd(c.getNickname(), nickOut + ": [send for " + nickIn + "] msg: " + str);
                   c.sendMSG(nickOut + ": [send for " + nickIn + "] msg: " + str);
               }
           }
       }
   }
