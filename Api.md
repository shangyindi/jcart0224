## 1.1 商品查询列表（降序）

URL: /producer/search?productName={productName}?productCode={productCode}?rewordPoints=#{rewordPoints}   
Method：GET  

ResponseBody:  
```json
[
    {
        "productrId":1,
        "productName": "华为001",
        "price": 238.00,
        "productCode": 001,
        "productAbstract": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
        "stockQuantity": 150000,
        "status": 1,
        "rewordPoints":150,
        "discount":200.00,
        "sortOrder":1,
        "mainPicUrl":"http://localhost:8086/XXX.png",
    },
    {
        "productrId":1,
        "productName": "华为002",
        "price": 234.00,
        "productCode": 002,
        "productAbstract": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
        "stockQuantity": 150000,
        "status": 1,
        "rewordPoints":150,
        "discount":200.00,
        "sortOrder":1,
        "mainPicUrl":"http://localhost:8086/XXX.png",
    }
]

```


Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productrId   | Integer   | 商品Id    |
| productName   | String   | 商品名    |
| price   | Double   |    商品价格    |
| productCode   | int   | 商品编号    |
| productAbstract   | String   | 商品摘要    |
| status   | tinyint   | 商品状态    |
| mainPicUrl   | String   | 商品主图片路径    |
| rewordPoints   | int   | 商品积分     |
| discount   | Double   | 商品打折     |
| sortOrder   | tinyint   | 商品排序（0.升序 1.降序）     |


## 1.2 商品添加 

URL: /product/create  
Request Content-Type: application/json(默认)  
Method：POST 

RequestBody:  
```json
{
        "productName": "小米",
        "price": 2000.00,
        "productCode": 056,
        "productAbstract": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
        "stockQuantity": 10000,
        "status": 0,
        "rewordPoints":112,
        "discount":1900.00,
        "sortOrder":0,
        "mainPicUrl":"http://localhost:8086/XXX.png",
}

```

ResponseBody:  
```json
succeed

```

Request Field  

| 字段     |     类型 |   描述   | 
Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productName   | String   | 商品名    |
| price   | Double   |    商品价格    |
| productCode   | int   | 商品编号    |
| productAbstract   | String   | 商品摘要    |
| status   | tinyint   | 商品状态    |
| mainPicUrl   | String   | 商品主图片路径    |
| rewordPoints   | int   | 商品积分     |
| discount   | Double   | 商品打折     |
| sortOrder   | tinyint   | 商品排序（0.升序 1.降序）     |


## 1.3 商品图片上传

URL: /product/upload  
Method：POST  
Request Content-Type: multipart/formdata    
RequestParam: productId  
RequestParam: product  

ResponseBody:  
```json
[
    "http://xxx.com/xxx1.jpg",
    "http://xxx.com/xxx2.jpg"
]

```

Request Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| productId   | Integer   | 商品Id    |
| product   | String   | 上传文件key    |

Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| mainPicUrl   | Array(String（JSON）)   | 上传图片后Urls    |


## 2.1 订单列表
URL: /order/search?shipMethod={shipMethod}?payMethod={payMethod}?rewordPoints=#{rewordPoints}   
Method：GET  

ResponseBody:  
```json
[
    {
        "orderId":1,
        "status":1,
        "rewordPoints":150,
        "shipMethod":1,
        "payMethod":2,
        "totalPrice":5269.56,
        "createTime":"2020/02/24 15:35 45:2050",
        "customerId":1
    }
]
```
Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| orderId | int | 订单ID | 
| status | tinyint | 订单状态 |
| rewordPoints | int | 订单积分 |
| shipMethod | tinyint | 寄送方式 |
| payMethod | tinyint | 支付方式 |
| totalPrice | Double | 订单总金额 |
| createTime | dataTime | 创建订单时间  |
| customerId | int | 外键客户 |  



## 3.1 用户查询
URL: /administrator/search?userName={userName}?createTime={createTime}?realName=#{realName}   
Method：GET  

ResponseBody:  
```json
[
    {
        "administratorId":1,
        "userName":"shangyindi",
        "status":1,
        "createTime":"2020/02/24 15:35 45:2050",
        "avatarUrl":"http://localhost:8086/a.jpg",
        "email":"221597984@qq.com",
    }
]
```  
Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| administratorId | int | 用户ID |
| userName | String | 用户姓名 |
| status | tinyint | 用户状态 |
| createTime | datatime | 用户创建时间 |
| avatarUrl | String | 用户图像URL |
| email | String | 用户邮箱 |  



## 3.2 用户创建 
URL: /administrator/create  
Request Content-Type: application/json(默认)  
Method：POST 

RequestBody:  
```json
{
        "userName": "shangyindi",
         "status":1,
        "createTime":"2020/02/24 15:35 45:2050",
        "avatarUrl":"http://localhost:8086/a.jpg",
        "email":"221597984@qq.com",
        "encryptedPassword":"XXXXXXXXXXXXXXXXXX",
}

```

ResponseBody:  
```json
succeed

```
Response Field  

| 字段     |     类型 |   描述   | 
| :--------------: | :--------:| :------: |
| userName | String | 用户姓名 |
| status | tinyint | 用户状态 |
| createTime | datatime | 用户创建时间 |
| avatarUrl | String | 用户图像URL |
| email | String | 用户邮箱 |  
| encryptedPassword | String | 用户加密密码 |  


