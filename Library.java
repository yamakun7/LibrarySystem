import java.util.*;
class Library{
	private Map<String,CollectionBooks> libraryList = new HashMap<String,CollectionBooks>();
	
	Map<String,CollectionBooks> getList(){ //�����ꗗ��Ԃ��B
		return libraryList;
	}

	void addLibrary(CollectionBooks object){ //�ꗗ�ɏo�ŕ���������B
		libraryList.put(object.ISBN, object);
	}

	boolean isHave(String ISBN){ //�^����ꂽISBN�ԍ������o�ŕ��������Ă��邩�B
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
			System.out.println("ISBN�ԍ������݂��܂���B");
		}
	}

	void giveBackCollectionBooks(String ISBN){
		if(isHave(ISBN)){
			CollectionBooks book = libraryList.get(ISBN);
			book.giveBack();
		}
	}
}