package com.jskj.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jskj.entities.*;
import com.jskj.order.dao.OrderMapper;
import com.jskj.order.service.OrderServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author lintao
 */
@Service
public class OrderSerImpl implements OrderServiceInf {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired private OrderMapper ordermapper;

    /**
     * 查找该用户所有订单
     */
    public List<OrderListSeach> orderlist(Userinfo use, Integer page, Integer limit) {
        return orderMapper.orderlist(use.getUid(),(page-1)*limit,limit);
    }

    /**
     * 查询订单的总数
     */
    public Object count(Userinfo order) {
        // TODO Auto-generated method stub
        return orderMapper.count(order);
    }

    /**
     * 删除单个订单
     */
    public Integer deleteByOid(Orderinfo orderinfo) {
        // TODO Auto-generated method stub
        return orderMapper.deleteByOid(orderinfo);
    }

    /**
     * 修改单个的订单状态
     */
    public Integer deleteStateByOid(Orderinfo orderinfo) {
        return orderMapper.deleteStateByOid(orderinfo);
    }

    /**
     * 批量删除
     */
    public Integer deleteAllByOid(List<String> a) {
        return orderMapper.deleteAllByOid(a);
    }

    /**
     * 批量退款
     */
    public Integer refundAll(List<String> a) {
        return  orderMapper.refundAll(a);
    }

    /**
     * 按条件查询订单
     */
    public List<Orderinfo> orderlistByCondition(Userinfo use, Integer page,
                                                Integer limit, String times, String content) {
        Pattern pattern = Pattern.compile("^\\d+$");
        if("" == times){
            //时间为空
            if(pattern.matcher(content).matches()){
                //订单编号
                return orderMapper.orderByConditionidnotime(use.getUid(),(page-1)*limit,limit,content);
            }else {
                //收件人
                content = "%"+content+"%";
                return orderMapper.orderByConditionnamenotime(use.getUid(),(page-1)*limit,limit,content);
            }
        }else {
            System.out.println("初始时间："+times);
            String[] t = times.replace("年", "-").replace("月", "-").replace("日", "").split("到");
            System.out.println("时间开始："+t[0]);
            if(pattern.matcher(content).matches()){
                return orderMapper.orderlistByConditionid(use.getUid(),(page-1)*limit,limit,t[0],t[1],content);
            }else {
                content = "%"+content+"%";
                return orderMapper.orderlistByConditionname(use.getUid(),(page-1)*limit,limit,content,t[0],t[1]);
            }
        }



    }

    /**
     * 按条件查询的总数
     */
    public Object countByCondition(Userinfo use, String times, String content) {
        Pattern pattern = Pattern.compile("^\\d+$");
        System.out.println("是数字?==="+pattern.matcher(content).matches());
        System.out.println(content);

        if("" == times){
            //时间为空
            if(pattern.matcher(content).matches()){
                //订单编号
                return orderMapper.orderBycountidnotime(use.getUid(),content);
            }else {
                //收件人
                content = "%"+content+"%";
                return orderMapper.orderBycounnamenotime(use.getUid(),content);
            }
        }else {
            String[] t = times.replace("年", "-").replace("月", "-").replace("日", "").split("到");
            if(pattern.matcher(content).matches()){
                return orderMapper.orderlistBycountid(use.getUid(),t[0],t[1],content);
            }else {
                content = "%"+content+"%";
                return orderMapper.orderlistBycountname(use.getUid(),content,t[0],t[1]);
            }
        }
    }

    //邱思琪部分
    public PageInfo<OrmanaViewbean> showOrders(Integer page, Integer pageSize, String time, String content, String uid, String uoid) {
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        //在帮助类中传入分页参数
        PageHelper.startPage(page, pageSize);
        String stime = "";
        String etime = "";
        if(time !="" && time!= null){
            String[] split = time.split("到");
            stime = split[0].trim();
            etime = split[1].trim();
        }
        System.out.println(stime+";"+etime+"~~~~");
        if(content !=null && content != ""){
            content ="%"+content+"%";
        }
        System.out.println(content+"~~~");
        System.out.println(uid);
        System.out.println(uoid);
        List<OrmanaViewbean> list = ordermapper.findAllOrder(time,stime, etime, content,uid,uoid);
        System.out.println(list);
        PageInfo<OrmanaViewbean> pagelist = new PageInfo<OrmanaViewbean>();
        pagelist.setList(list);
        return pagelist;
    }

    public int deleteOrdersByoids(String[] oids) {
        return ordermapper.deleteOrdersByoids(oids);
    }

    public int deleteOrdersByoid(String oid) {
        return ordermapper.deleteOrdersByoid(oid);
    }

    public int agreeproducByoids(String[] oids) {
        return ordermapper.agreeproducByoids(oids);
    }

    public int agreerefundByoids(String[] oids) {
        return ordermapper.agreerefundByoids(oids);
    }
    //邱思琪部分
    @Override
    public List<Kind> searchPhoneModel() {
        // TODO Auto-generated method stub
        return orderMapper.selectKindAndBrands();
    }
    @Override
    public int addCrat(Excleinfo info) {
        // TODO Auto-generated method stub
        System.out.println(info);
        return orderMapper.insertCart(info);
    }
    @Override
    public List<Excleinfo> searchCart(Integer page,Integer limit,Integer uid, Integer extype) {
        // TODO Auto-generated method stub
        System.out.println(uid);
        return orderMapper.selectCart((page-1)*limit,limit,uid, extype);
    }
    @Override
    public long countCart(Integer uid, Integer extype) {
        // TODO Auto-generated method stub
        return orderMapper.countCart(uid, extype);
    }
    @Override
    public int deleteUser(Integer exid) {
        // TODO Auto-generated method stub
        return orderMapper.deleteUser(exid);
    }
    @Override
    public int addOrder(List<Integer> lids,Userinfo info) {
        // TODO Auto-generated method stub
        Userinfo userinfo = orderMapper.selectUser(info.getUno(),info.getUpwd());
        if (userinfo != null) {
            Orderinfo orderinfo = new Orderinfo();
            String oid = getOrderIdByTime();
            orderinfo.setOid(oid);
            orderinfo.setUid(info.getUid());
            double osale = 0;
            List<Excleinfo> list = orderMapper.selectCarts(lids);
            for (int i = 0; i < lids.size(); i++) {//删除临时表数据
                int delete = orderMapper.delete(lids);
            }
            for(int i= 0;i<list.size();i++){
                double sale = list.get(i).getOsale();
                sale = sale+list.get(i).getSlingnumber()+list.get(i).getHoldernumber();
                osale = osale+sale;
            }
            orderinfo.setOsale(osale);
            orderinfo.setOstate(4);
            orderinfo.setOdelete(1);
            orderMapper.insertOrder(orderinfo);
            for (int i = 0; i < list.size(); i++) {
                Excleinfo excleinfo = list.get(i);
                Orderdetails orderdetails = new Orderdetails();
                orderdetails.setPid(excleinfo.getPid());//手机型号
                orderdetails.setOid(oid);//订单编号
                int photoid = orderMapper.insertPhoto(excleinfo.getPhotosrc(),null);
                orderdetails.setPhotoid(photoid);//图片编号
                int phoneid = orderMapper.insertContact(excleinfo.getConnumber());//获取联系表编号
                Logisticsinfo logisticsinfo = new Logisticsinfo();
                logisticsinfo.setLame(excleinfo.getLame());
                logisticsinfo.setLadress(excleinfo.getLadress());
                logisticsinfo.setOid(oid);
                logisticsinfo.setContactid(phoneid);
                logisticsinfo.setLdelete(1);
                int Lid = orderMapper.insertLogisticsinfo(logisticsinfo);//获取物流表编号
                orderdetails.setLid(Lid);//插入物流编号
                orderdetails.setPnnumber(excleinfo.getPnnumber());//插入数量
                orderdetails.setOremark(excleinfo.getOremark());//插入备注
                orderdetails.setContactid(phoneid);
                orderdetails.setUid(info.getUid());
                int orderdetailid = orderMapper.insertOrderdetails(orderdetails);
                Complimentary complimentary = new Complimentary();
                complimentary.setOdid(orderdetailid);//存入订单详情id
                if (excleinfo.getSlingnumber() != null && excleinfo.getSlingnumber()!=0) {//存入挂绳数量
                    int Slingnumber = (int) (excleinfo.getSlingnumber()/5);
                    complimentary.setSlingnumber(Slingnumber);
                }else{
                    complimentary.setSlingnumber(0);
                }
                if (excleinfo.getHoldernumber() != null && excleinfo.getHoldernumber()!=0) {//存入支架数量
                    int Slingnumber = (int) (excleinfo.getSlingnumber()/5);
                    complimentary.setHoldernumber(Slingnumber);
                }else{
                    complimentary.setHoldernumber(0);
                }
                int complimentaryid = orderMapper.insertComplimentary(complimentary);
            }
            return 1;
        }
        return 0;
    }
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }
    @Override
    public int insertExcel(List<Excleinfo> excleinfos) {
        // TODO Auto-generated method stub
        return orderMapper.insertExcel(excleinfos);
    }

    @Override
    public Orderinfo selectceshi() {
        Orderinfo ori = orderMapper.selectceshi();
        return ori;
    }
}
