var app = new Vue({
    el: '#app',
    data: {
        pageInfo: '',
        pageNum: 1,
        selectStatus:0,
        statuses: [
        { value: 0, label: '禁用' },
        { value: 1, label: '启用' },
        { value: 2, label: '不安全' }]
    },
    mounted() {
        console.log('View mounted');
        //进行赋值
        this.searchCustomer();
    },
    methods: {
        handlePageChange(val) {
            console.log('page change')
            this.pageNum = val;
            this.searchProduct();
        },
        searchCustomer() {
            axios.get('http://localhost:8080/customer/search', {
                params: {
                    pageNum: this.pageNum,
                    pageInfo: this.pageInfo
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})