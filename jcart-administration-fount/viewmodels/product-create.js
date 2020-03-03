var app = new Vue({
    el: '#app',
    data: {
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        sortOrder: '',
        description: '',
        selectedStatus: '',
        statuses: [{
            value: 0, label: '下架',
        }, {
            value: 1, label: '上架',
        },{
            value: 2, label: '待审核',
        }],
        mainPicUrl:''

    },
    methods: {
        handleCreateClick() {
            console.log('create Product')
            this.createProduct();
        },
        createProduct() {
            axios.post('/product/create', {
                params: {
                    productCode: this.productCode,
                    productName: this.productName,
                    price: this.price,
                    discount: this.discount,
                    stockQuantity: this.stockQuantity,
                    rewordPoints: this.rewordPoints,
                    sortOrder: this.sortOrder,
                    description: this.description,
                    status: this.selectedStatus,
                    selectStatus: this.selectStatus,
                    mainPicUrl:this.mainPicUrl
                }
            })
                .then(function (response) {
                    console.log('创建成功');
                })
                .catch(function (error) {
                    console.log('创建失败');
                });
        }
    }
})