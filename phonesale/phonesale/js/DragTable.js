//��ȡĿ��
function MouseDownToResize(obj){
obj.mouseDownX=event.clientX;
obj.pareneTdW=obj.parentElement.offsetWidth;
//obj.pareneTableW=mytable.offsetWidth;
obj.setCapture();
}
//�϶�Ŀ��
//download by http://www.codefans.net
function MouseMoveToResize(obj){
    if(!obj.mouseDownX) return false;
    var newWidth=obj.pareneTdW*1+event.clientX*1-obj.mouseDownX;
    if(newWidth>0)
    {
obj.parentElement.style.width = newWidth;
//mytable.style.width=obj.pareneTableW*1+event.clientX*1-obj.mouseDownX;
}
}
//�ͷ�Ŀ��
function MouseUpToResize(obj){
obj.releaseCapture();
obj.mouseDownX=0;
}
