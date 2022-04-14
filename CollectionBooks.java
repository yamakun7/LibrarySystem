abstract class CollectionBooks {
	
	protected String ISBN;
	protected String title;
	protected String publisher;
	protected int publishYear;
	protected boolean isLend; //�ݏo���ł����true,�@�ԋp���ł����false

	String getISBN(){
		return ISBN;
	}
	String getTitle(){
		return title;
	}
	String getPublisher(){
		return publisher;
	}
	int getPublishYear(){
		return publishYear;
	}
	boolean getIsLend(){
		return isLend;
	}

	abstract boolean lend();

	boolean giveBack(){
		if(isLend==true){
			isLend=false;
			return true;
		}
		else{
			System.out.println("�݂��o����Ă��܂���B");
			return false;
		}
	}

	CollectionBooks(String ISBN, String title, String publisher, int publishYear) throws Exception{
		if(ISBN.length()!=13){
			throw new Exception("ISBN�ԍ�������������܂���Baaaaaa");
		}
		if(publishYear < 0){
			throw new Exception("�o�ŔN������������܂���B");
		}
		this.ISBN = ISBN;
		this.title = title;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.isLend=false;
	}
	
}