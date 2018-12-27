
const deviceUtil = {

	/** 모바일기기인지 판별한다 */
	isMobile() {
		const filter = "win16|win32|win64|mac|macintel"
		const realMobileDevice = navigator.platform && (filter.indexOf(navigator.platform.toLowerCase()) < 0)
		const mobileWeb = /(Android)/.test(navigator.userAgent)
		return realMobileDevice || mobileWeb
	}

}


export default deviceUtil