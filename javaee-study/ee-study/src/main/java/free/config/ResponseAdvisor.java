package free.config;

//@ControllerAdvice
public class ResponseAdvisor {
//        implements ResponseBodyAdvice {
//    @Override
//    public boolean supports(MethodParameter returnType, Class aClass) {
//        //返回true表示请求体响应数据时，先执行beforeBodyWrite，false就不执行
//        //获取请求方法对象，判断Controller方法上是否有@ResponseBody
//        return returnType.getMethod().
//                getAnnotation(ResponseBody.class) != null;
//    }
//
//    //body为请求方法执行完之后，返回的对象
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        Response resp = new Response();
//        resp.setSuccess(true);
//        resp.setData(body);
//        return resp;
//    }
}
