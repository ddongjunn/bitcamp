//import java.io.*;
//
//public class DataProcess {
//    private File file;
//
//    public DataProcess(String fileName){
//        file = new File("C:\\workspace\\java\bitcamp\\day09"+ fileName + ".txt");
//    }
//
//    public void createFile(){
//        try{
//            if(file.createNewFile()){
//                System.out.println("파일 생성 성공!");
//            }else{
//                System.out.println("파일 생성 실패!");
//            }
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//    }
//
//    public String[] fileLoad(){
//        String datas[] = null;
//
//        try{
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//            //data의 총수를 구한다.
//            int count = 0;
//            String str = "";
//
//            while((str = br.readLine()) != null){
//                count ++;
//            }
//            br.close();
//
//            //data 할당
//            datas = new String[count];
//
//            //data 취합
//            br = new BufferedReader(new FileReader(file));
//            int w = 0;
//            while((str = br.readLine()) != null){
//                datas[w] = str;
//                w++;
//            }
//            br.close();
//        }catch(FileNotFoundException fnfe){
//            fnfe.printStackTrace();
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//        return datas;
//    }
//    public void fileSave(String[] datas){
//        try{
//            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//
//            for(int i=0; i<datas.length; i++){
//                pw.println(datas[i]);
//            }
//        }catch(IOException ioe){
//            ioe.printStackTrace();
//        }
//
//        System.out.println("파일에 저장되었습니다.");
//    }
//}
