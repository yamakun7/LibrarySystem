import java.util.*;
class Library{
	private Map<String,CollectionBooks> libraryList = new HashMap<String,CollectionBooks>();
	
	Map<String,CollectionBooks> getList(){ //蔵書一覧を返す。
		return libraryList;
	}

	void addLibrary(CollectionBooks object){ //一覧に出版物を加える。
		libraryList.put(object.ISBN, object);
	}

	boolean isHave(String ISBN){ //与えられたISBN番号を持つ出版物を持っているか。
		for(String num : libraryList.keySet()){
			if(num.equals(ISBN)){
				return true;
			}
		}
		return false;
	}

	void lendCollectionBooks(String ISBN){
		if(isHave(ISBN)){
			CollectionBooks book = libraryList.get(ISBN);
			System.out.println(book.title);
			book.lend();
		}else{
			System.out.println("ISBN番号が存在しません。");
		}
	}

	void giveBackCollectionBooks(String ISBN){
		if(isHave(ISBN)){
			CollectionBooks book = libraryList.get(ISBN);
			book.giveBack();
		}
	}
}