class Book extends CollectionBooks{
	private String author;
	
	String getAuthor(){
		return author;
	}

	@Override
	boolean lend(){
		if(isLend==false){
			isLend = true;
			return true;
		}
		else{
			System.out.println("���ݑ݂��o�����ł��B");
			return false;
		}
	}
	
	@Override
	public String toString(){
		return "Book," + ISBN + "," + title + "," + author + "," + publisher + "," + publishYear;
	}

	Book(String ISBN, String title, String author, String publisher, int publishYear) throws Exception{
		super(ISBN, title, publisher, publishYear);
		this.author = author;
	}

}