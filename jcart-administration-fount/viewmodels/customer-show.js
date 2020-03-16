var app = new Vue({
    el: '#app',
    data: {
      customerId:'',
      username:'',
      realName:'',
      mobile:'',
      email:'',
      status:'',
      createTimestamp:'',
      defaultAddress:''
    },
    mounted() {
        console.log('View mounted');
        var url = new URL(location.href);
        this.customerId = url.searchParams.get("customerId");
        if (!this.customerId) {
            alert('customerId is null')
            return;
        }
        //进行赋值
        this.getByIdCustomer();

    },
    methods: {
        getByIdCustomer() {
            axios.get('http://localhost:8080/customer/getById', {
                params: {
                    customerId: this.customerId
                }
            })
                .then(function (response) {
                    console.log(response);

                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})