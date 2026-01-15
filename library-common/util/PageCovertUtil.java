public class PageCovertUtil {
    public static <P, V> IPage<V> pageVoCovert(IPage<P> pageInfo, Class<V> v){
        try{
            if (pageInfo != null){
                //IPage<V>是MyBatis-Plus 自己定義的介面，用來表示一整頁的查詢結果
                IPage<V> page = new Page<>(pageInfo.getCurrent(), pageInfo.getSize());
                page.setTotal(pageInfo.getTotal());

                //將型別p的資料轉換成型別v
                List<P> records = pageInfo.getRecords();
                List<V> list = new ArrayList<>();
                for (P record : records){
                    if (record != null){
                        v.getDeclaredConstructor().newInstance();
                        BeanUtil.copyProperties(record, newV);
                        list.add(newV);
                    }
                }
                page.setRecords(list);
                page.setTotal(pageInfo.getTotal());
                return page;
''
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}