//���͎���"4"����͂��邱�ƂŐ}���كV�X�e�����I�������邱�Ƃ��ł���B
import java.util.*;
import java.io.*;
class LibrarySystem{
	public static void main(String[] args){
		Library library = new Library();

		//�����쐬�ƒǉ�
		/*
		try{
			CollectionBooks a = new Book("1234567890123","�V�����","�Ėڟ���","�u�k��",1990);
			CollectionBooks b = new Magazine("2345678901234","���y�̗F",2012,1,"���y�̗F��",2012);
			CollectionBooks c = new Book("1234567890321","�Ԗт̃A��","�����S����","���w��",1989);
			library.addLibrary(a);
			library.addLibrary(b);
			library.addLibrary(c);
		}catch(Exception e){
			System.out.println(e);
		}
		*/

		//csv�t�@�C����ǂݍ��݃f�[�^�쐬�B
		try{
			String fileName = "Data.csv"; //�t�@�C����java�t�@�C���Ɠ����f�B���N�g���ɂ�����̂Ƃ���B
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String item=reader.readLine();
			while(item!=null){
				System.out.println(item);
				String[] items = item.split(",");
				if(items[0].equals("Book")){
					CollectionBooks book = new Book(items[1], items[2], items[3], items[4], Integer.parseInt(items[5]));
					if(items[6].equals("�ݏo")){
						book.isLend=true;
					}
					library.addLibrary(book);
				}
				else if(items[0].equals("Magazine")){
					CollectionBooks magazine = new Magazine(items[1], items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4]), items[5], Integer.parseInt(items[6]));
					if(items[7].equals("�ݏo")){
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
		
		//���[�U����
		try{

			Scanner scanner = new Scanner(System.in);
			
			String line="";
			System.out.println("��������͂��Ă��������B");
			while(scanner.hasNext()){
				if((line = scanner.nextLine()).equals("4")){
					break;
				}
				switch(line){
					case "1":
					System.out.println("�ǉ�����}���̓��e����͂��Ă��������B");
					
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
					case "2": //�؂��
					System.out.println("�؂肽���{��ISBN�ԍ�����͂��Ă��������B");
					if(scanner.hasNext()){
						String num = scanner.nextLine();
						library.lendCollectionBooks(num);
					}
					break;
					case "3": //�ԋp
					System.out.println("�ԋp�������{��ISBN�ԍ�����͂��Ă��������B");
					if(scanner.hasNext()){
						String num = scanner.nextLine();
						library.giveBackCollectionBooks(num);
					}
					break;
				}
				System.out.println("��������͂��Ă��������B");
			}
			scanner.close();

		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("�����p���肪�Ƃ��������܂����B");

		//�t�@�C�������o��
		String filename="Data.csv";
		try{
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			Map<String,CollectionBooks> map = library.getList();
			for(CollectionBooks list : map.values()){
				System.out.println(list.toString());
				writer.print(list.toString());
				if(list.getIsLend()){
					writer.println(",�ݏo");
				}
				else{
					writer.println(",�ԋp");
				}
			}
			writer.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
}