var app = new Vue({
    el: '#app',
    data: {
        username: '',
        realName: '',
        mobile: '',
        password: '',
        respassword: '',
        email: '',
        newsSubscribed: false,
        selectStatus: 0,
        statuses: [
            {
                value: 0,
                label: '禁用'
            },
            {
                value: 1,
                label: '启用'
            },
            {
                value: 2,
                label: '不安全'
            }
        ]
    },
    methods: {
        handleRegisterClick() {
            console.log('register click')
            if (this.password != this.respassword) {
                alert('两次密码不一致')
                return;
            }
            this.customerRegister();
        },
        customerRegister() {
            axios.post('/customer/register', {
                username: this.username,
                realName: this.realName,
                mobile: this.mobile,
                password: this.password,
                email: this.email,
                newsSubscribed: this.newsSubscribed,
                status:this.selectStatus
            }).then(function (response) {
                console.log(response)
                alert('注册成功');
            }).catch(function (error) {
                console.log(error)
            })
        }
    },

})