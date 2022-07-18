function opnWrapperFinance(event) {
	const btnOpnCampFinance = document.querySelector('#btnOpnCampFinance');
	const wrapper = document.querySelector(".wrapper-camp-finance");

	btnOpnCampFinance.classList.toggle("opened");
	wrapper.classList.toggle("opened");

	return false;
}