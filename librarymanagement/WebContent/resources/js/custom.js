$(function() {
	
	// Active menu
	switch (menu) {

	case '/addBook.xhtml':
		$('#addBook').addClass('active');
		break;
	case '/manageCategory.xhtml':
		$('#manageCategory').addClass('active');
		break;
	case '/viewBooks.xhtml':
		$('#viewBooks').addClass('active');
		break;
		
	}
});