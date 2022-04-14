//入力時に"4"を入力することで図書館システムを終了させることができる。
import java.util.*;
import java.io.*;
class LibrarySystem{
	public static void main(String[] args){
		Library library = new Library();

		//蔵書作成と追加
		/*
		try{
			CollectionBooks a = new Book("1234567890123","坊ちゃん","夏目漱石","講談社",1990);
			CollectionBooks b = new Magazine("2345678901234","音楽の友",2012,1,"音楽の友社",2012);
			CollectionBooks c = new Book("1234567890321","赤毛のアン","モンゴメリ","小学館",1989);
			library.addLibrary(a);
			library.addLibrary(b);
			library.addLibrary(c);
		}catch(Exception e){
			System.out.println(e);
		}
		*/

		//csvファイルを読み込みデータ作成。
		try{
			String fileName = "Data.csv"; //ファイルはjavaファイルと同じディレクトリにいるものとする。
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String item=reader.readLine();
			while(item!=null){
				System.out.println(item);
				String[] items = item.split(",");
				if(items[0].equals("Book")){
					CollectionBooks book = new Book(items[1], items[2], items[3], items[4], Integer.parseInt(items[5]));
					if(items[6].equals("貸出")){
						book.isLend=true;
					}
					library.addLibrary(book);
				}
				else if(items[0].equals("Magazine")){
					CollectionBooks magazine = new Magazine(items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), items[5], Integer.parseInt(items[6]));
					if(items[7].equals("貸出")){
						magazine.isLend=true;
					}
					library.addLibrary(magazine);
				}
				item=reader.readLine();
			}
			reader.close();
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);	
		}catch(Exception e){
			System.out.println(e);	
		}
		
		//ユーザ操作
		try{

			Scanner scanner = new Scanner(System.in);
			
			String line="";
			System.out.println("数字を入力してください。");
			while(scanner.hasNext()){
				if((line = scanner.nextLine()).equals("4")){
					break;
				}
				switch(line){
					case "1":
					System.out.println("追加する図書の内容を入力してください。");
					
					if(scanner.hasNext()){	
						String item = scanner.nextLine();
						String[] items = item.split(",");
						System.out.println("Title: "+items[0]);
						if(items[0].equals("Book")){
							CollectionBooks book = new Book(items[1], items[2], items[3], items[4], Integer.parseInt(items[5]));
							library.addLibrary(book);
						}
						else if(items[0].equals("Magazine")){
							CollectionBooks magazine = new Magazine(items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), items[5], Integer.parseInt(items[6]));
							library.addLibrary(magazine);
						}
					}
					break;
					case "2": //借りる
					System.out.println("借りたい本のISBN番号を入力してください。");
					if(scanner.hasNext()){
						String num = scanner.nextLine();
						library.lendCollectionBooks(num);
					}
					break;
					case "3": //返却
					System.out.println("返却したい本のISBN番号を入力してください。");
					if(scanner.hasNext()){
						String num = scanner.nextLine();
						library.giveBackCollectionBooks(num);
					}
					break;
				}
				System.out.println("数字を入力してください。");
			}
			scanner.close();

		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("ご利用ありがとうございました。");

		//ファイル書き出し
		String filename="Data.csv";
		try{
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			Map<String,CollectionBooks> map = library.getList();
			for(CollectionBooks list : map.values()){
				System.out.println(list.toString());
				writer.print(list.toString());
				if(list.getIsLend()){
					writer.println(",貸出");
				}
				else{
					writer.println(",返却");
				}
			}
			writer.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
}