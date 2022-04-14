abstract class CollectionBooks {
	
	protected String ISBN;
	protected String title;
	protected String publisher;
	protected int publishYear;
	protected boolean isLend; //貸出中であればtrue,　返却中であればfalse

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
			System.out.println("貸し出されていません。");
			return false;
		}
	}

	CollectionBooks(String ISBN, String title, String publisher, int publishYear) throws Exception{
		if(ISBN.length()!=13){
			throw new Exception("ISBN番号が正しくありません。aaaaaa");
		}
		if(publishYear < 0){
			throw new Exception("出版年が正しくありません。");
		}
		this.ISBN = ISBN;
		this.title = title;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.isLend=false;
	}
	
}