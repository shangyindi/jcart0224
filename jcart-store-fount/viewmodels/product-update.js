var app = new Vue({
    el: '#app',
    data: {
        productId: '',
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        sortOrder:'',
        productAbstract: '',
        description: '',
        selectedStatus: 1,
        selectedMainPic: '',
        mainPicUrl: '',
        selectedOtherPics: [],
        otherPicUrls: [],
        statuses: [
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ],
        mainFileList: [],
        otherFileList: [],
        quantity:1,
        myProducts:[]
    },
    mounted() {
        console.log('view mounted');
        var myProducts = localStorage['myShoppingCart'];
        this.myProducts = myProducts ? JSON.parse(myProducts) : [];
        var url = new URL(location.href);
        this.productId = url.searchParams.get("productId");
        if (!this.productId) {
            alert('productId is null')
            return;
        }
        this.getProductId();


    },
    methods: {
        addToShoppingCart(){
            console.log('add to cart cilck')   
            var newProduct = {
                productId: this.productId,
                productCode:this.productCode,
                productName:this.productName,
                mainPicUrl:this.mainPicUrl,
                unitPrice:this.price,
                quantity:this.quantity,
            };
            newProduct.totalPrice = this.quantity * this.price;
            this.myProducts.push(newProduct);       
            localStorage['myShoppingCart'] =JSON.stringify(this.myProducts);    
        },
        handleCreateClick() {
            console.log('create click');
            this.description = tinyMCE.activeEditor.getContent();
            this.createProduct();
        },
        handleOnMainChange(val) {
            this.selectedMainPic = val.raw;
        },
        handleUploadMainClick() {
            console.log('upload main pic click');
            this.uploadMainImage();
        },
        uploadMainImage() {
            var formData = new FormData();
            formData.append("image", this.selectedMainPic);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.mainPicUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        handleOnOtherChange(file, fileList) {
            console.log('fileList', fileList);
            this.selectedOtherPics = fileList;
        },
        handleOnOtherRemove(file, fileList) {
            console.log('fileList', fileList);
            this.selectedOtherPics = fileList;
        },
        handleUploadOtherClick() {
            console.log('upload other pic click');
            this.uploadOtherImage();
        },
        uploadOtherImage() {
            this.selectedOtherPics.forEach(pic => {
                var formData = new FormData();
                formData.append("image", pic.raw);

                axios.post('/image/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then(function (response) {
                        console.log(response);
                        var url = response.data;
                        app.otherPicUrls.push(url);
                    })
                    .catch(function (error) {
                        console.log(error);
                        alert('上传失败');
                    });
            });


        },updatedClick(){
            axios.post('/product/update', {
                productId: this.productId,
                productName: this.productName,
                price: this.price,
                discount: this.discount,
                stockQuantity: this.stockQuantity,
                status: this.selectedStatus,
                mainPicUrl: this.mainPicUrl,
                rewordPoints: this.rewordPoints,
                sortOrder: this.sortOrder,
                productAbstract: this.productAbstract,
                description: this.description,
                otherPicUrls: this.otherPicUrls
            })
                .then(function (response) {
                    console.log(response);
                    alert('修改成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getProductId(){
            axios.get('/product/getById',{
                params:{
                    productId:this.productId,
                }
            }).then(function (response) {
                console.log(response);
                var product = response.data;
                app.productId=product.productId;
                app.productCode=product.productCode;
                app.discount = product.discount;
                app.stockQuantity = product.stockQuantity;
                app.selectedStatus = product.status;
                app.rewordPoints = product.rewordPoints;
                app.sortOrder = product.sortOrder;
                app.mainPicUrl = product.mainPicUrl;
                app.productAbstract = product.productAbstract;
                app.otherPicUrls = product.otherPicUrls;
                app.description = product.description;
                app.productName = product.productName;
                app.price=product.price;
            }).catch(function (error) {
                console.log(error)
            })
        }
    }
})