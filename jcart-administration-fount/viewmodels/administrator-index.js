var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum:1,
    },
    mounted(){
        console.log('View mounted');
        //进行赋值
        this.searchAdministrator();
    },
    methods:{
        handlePageChange(val){
            console.log('page change')
            this.pageNum = val;
            this.searchAdministrator();
        },
        searchAdministrator(){
            axios.get('http://localhost:8080/administrator/search', {
                params: {
                   pageNum:this.pageNum,
                   pageInfo:this.pageInfo
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;    
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        handleDelete(index, row) {
            console.log('delete click');
            if (confirm("确认删除？")) {
                administratorId = row.administratorId
                this.deleteAdministrator(administratorId);
                console.log(row.administratorId)
            }
        },
        deleteAdministrator(administratorId){
            axios.post('/administrator/delete',administratorId,{
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(function (response) {
                console.log(response)
                alert('删除成功')
                location.reload();
            }).catch(function (error) {
                console.log(error)
            })
        }
    }
})