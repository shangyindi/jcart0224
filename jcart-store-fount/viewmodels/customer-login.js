var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: '',
        respassword: '',
    },
    methods: {
        handleLoginClick() {
            console.log('login click')
            if (this.password != this.respassword) {
                alert('两次密码不一致')
                return;
            }
            this.customerLogin();
        },
        customerLogin() {
            axios.get('/customer/login', {
                params:{
                    username: this.username,
                    password: this.password,
                }
            }).then(function (response) {
                console.log(response);
                var dto = response.data;
                localStorage['jcartToken'] = dto.token;
                localStorage['expireTimestamp'] = dto.expireTimestamp;
                console.log(dto);
                alert('登陆成功');
            })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },

})