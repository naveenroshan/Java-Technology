- Project Outlook for the project :
	- Create Model and Repository
	- Create the REST Controller
	- Configure the datasource
	- Test

- Product Service : 
 	- Used to create product
 	- Call the coupon service when client apply any coupon

- CouponService :
 	- Used to create and store the coupon
 	- Expose the created coupons to the product services
	- create URL : http://localhost:8080/couponApi/coupons
		- payload : {"code":"NormalCode", "discount":10, "expDate":"12/12/2020"}
	- get Url: http://localhost:8080/couponApi/coupons/NormalCode

- MYSQL details :
	- Password: Root@123

- Dependencies :
	- Spring Web
	- Spring Data JPA
	- Mysql service
