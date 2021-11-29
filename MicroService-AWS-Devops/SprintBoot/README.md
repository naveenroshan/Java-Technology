- Project Outlook for the project :

	- Create Model and Repository
	- Create the REST Controller
	- Configure the datasource
	- Test

- Product Service : 
 	- Used to create the product and apply discount coupon and store the product
 	- Call the coupon service when client apply any coupon code to get the coupon discount value.

	-create URL: http://localhost:9090/productApi/products
		- payload : {"name": "Iphone","description": "value","price": 1000,"couponCode":"NormalCode"}

- CouponService :
 	- Used to create and store the coupon
 	- Expose the created coupons to the product services

	- create URL : http://localhost:8080/couponApi/coupons
		- payload : {"code":"NormalCode", "discount":10, "expDate":"12/12/2020"}
	- get Url: http://localhost:8080/couponApi/coupons/NormalCode

- Dependencies :
	- Spring Web
	- Spring Data JPA
	- Mysql service
