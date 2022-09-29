console.log($('#addrecipe'));
$('#addrecipe').click(()=>{
    console.log(this);
    window.location.href = 'addrecipe.jsp';
});