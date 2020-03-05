var app = new Vue({
    el: '#app',
    data: {
        username: '',
        password: '',
    },
    methods: {
        submitAdministratorClick() {
            console.log('submit login')
            this.loginAdministrator();
        },
        loginAdministrator() {
            console.log('login then');
            axios.get('/administrator/login',{
                params: {
                    username: this.username,
                    password: this.password
                }
            }).then(function (response) {
                console.log(response);
                var dto = response.data;
                localStorage['jcartToken'] = dto.token;
                localStorage['expireTimestamp'] = dto.expireTimestamp;
                alert('登录成功');
            }).catch(function (error) {
                console.log(error)
            })    
        }
    }
})