class Magazine extends CollectionBooks{
	private int volume;
	private int number;
	
	int getVolume(){
		return volume;
	}
	int getnumber(){
		return number;
	}

	@Override
	boolean lend(){
		if(isLend == false){
			if(publishYear < 2010){
				isLend = true;
				return true;
			}
			else{
				System.out.println("貸し出せません。");
				return false;
			}
		}
		else{
			System.out.println("現在貸し出し中です。");
			return false;
		}
	}

	@Override
	public String toString(){
		return "Magazine," + ISBN + "," + title + "," + volume + "," + number + "," + publisher + "," + publishYear ;
	}

	Magazine(String ISBN, String title,int volume, int number, String publisher, int publishYear) throws Exception{
		super(ISBN, title, publisher, publishYear);
		this.volume = volume;
		this.number = number;
	}

}