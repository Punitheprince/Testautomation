package tests;

import java.io.IOException;

import pages.Search_page;

public class Tests extends Search_page

{
	Search_page Search = new Search_page();
	
	public void Search_page_test() throws InterruptedException, IOException
	{
		
		
		Search.pagesetup();
		Search.search_items();
		
	}
	
}
