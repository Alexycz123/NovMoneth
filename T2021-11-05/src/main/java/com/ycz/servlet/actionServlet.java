package com.ycz.servlet;

import com.ycz.pojo.PageBean;
import com.ycz.pojo.Province;
import com.ycz.pojo.User;
import com.ycz.query.UserQuery;
import com.ycz.service.ProvinceService;
import com.ycz.service.UserService;
import com.ycz.service.impl.ProvinceServiceImpl;
import com.ycz.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.List;

@WebServlet("/user/*")
public class actionServlet extends BaseServlet {

   private static final UserService userService=new UserServiceImpl();
    private static final ProvinceService provinceService=new ProvinceServiceImpl();

    /**
     * 跳转到插入页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void toAddPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("去add的方法");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        request.setAttribute("page",page);
        request.setAttribute("limit",limit);
        List<Province> provinceList = provinceService.selectList();
        request.setAttribute("provinceList",provinceList);
        request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request,response);
    }

    /**
     * 插入
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap.keySet());

        String name = request.getParameter("name");
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        User user=userService.selectByName(name);
        User user2=new User();
        BeanUtils.populate(user2,parameterMap);
        if (user!=null){
            request.setAttribute("user",user2);
            List<Province> provinceList = provinceService.selectList();
            request.setAttribute("provinceList",provinceList);
            request.setAttribute("page",page);
            request.setAttribute("limit",limit);
            request.setAttribute("insertMsg","用户名已经使用过，请重新输入");
            request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request,response);
            return;
        }

        user=new User();
        BeanUtils.populate(user,parameterMap);
        user.setPwd("123456");
        System.out.println(user);
        Integer i=userService.insertUser(user);
        System.out.println(i>0?"插入成功":"插入失败");

        list(request,response);
    }

    /**
     * 跳转到更新页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void toUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("进来了更新页面");
        String id = request.getParameter("id");
        System.out.println(id);
         User user= userService.selectById(Integer.parseInt(id));

        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        request.setAttribute("page",page);
        request.setAttribute("limit",limit);

         request.setAttribute("user",user);
        List<Province> provinceList = provinceService.selectList();
        request.setAttribute("provinceList",provinceList);
        request.getRequestDispatcher("/WEB-INF/jsp/update.jsp").forward(request,response);
    }

    /**
     * 更新
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        BeanUtils.populate(user,parameterMap);
        System.out.println(user);

        Integer integer = userService.updateUserById(user);
        System.out.println(integer>0?"更新成功":"更新失败");

        list(request,response);
    }

    /**
     * 删除一条
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        System.out.println("要删除"+id);
       Integer i= userService.deleteById(id);
        System.out.println(i>0?"删除成功":"删除失败");
//        request.setAttribute("msg","操作成功");
        request.setAttribute("id",null);

        list(request,response);
    }

    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void delete2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String ids = request.getParameter("ids");
        System.out.println("要删除"+ids);

        String[] split = ids.split(",");
        ArrayList<Integer> lists=new ArrayList<>();
        for (String s : split) {
            lists.add(Integer.parseInt(s));
        }

        System.out.println(lists);
        Integer i=userService.deleteBatchById(lists);
        System.out.println(i>0?"批量删除成功":"批量删除失败");


        list(request,response);
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");//密码
        String verifycode = request.getParameter("verifycode");//获取的验证码
        System.out.println(username);
        System.out.println(password);
        System.out.println(verifycode);

        if (username==null || username.length()==0 || password==null || password.length()==0){
            request.setAttribute("loginMsg","用户名或密码或验证码不能为空");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }

        String code = request.getSession().getAttribute("code").toString();
        if (!code.equalsIgnoreCase(verifycode)){
            request.setAttribute("loginMsg","验证码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }

        User user=new User();
        user.setName(username);
        user.setPwd(password);
        User user1 = userService.selectById_pwd(user);
        if (user1!=null){
            HttpSession session = request.getSession();
            session.setAttribute("gender123",user1.getGender());
            session.setAttribute("loginName",user.getName());
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
        }else{
            request.setAttribute("loginMsg","用户名或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    /**
     * 传输list，分页，查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //假如插入或者更新的时候请求的是list（request，response）的数值
        //这样就不得行
        //所以要判断请求过来的是否有 qq 的值，如果有，则可以判断其是插入或者更新的值
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        UserQuery userQuery=new UserQuery();//封装了page，limit
        userQuery.setLoginName(request.getSession().getAttribute("loginName").toString());
        PageBean pageBean=new PageBean();
        System.out.println("province");
        List<Province> provinceList = provinceService.selectList();
        System.out.println("province");
        request.setAttribute("provinceList",provinceList);


        if (parameterMap.get("qq")!=null){ //直接跳转
            System.out.println("获取的session"+request.getSession().getAttribute("loginName"));
            Integer total=userService.selectCount(userQuery);
            pageBean.setLimit(userQuery.getLimit());//默认值的limit
            pageBean.setCount(total);//设置总数
            Integer userPageTotal=total%(userQuery.getLimit())==0?total/(userQuery.getLimit()):(total)/userQuery.getLimit()+1;
            pageBean.setUserPageTotal//设置总共有几页
                    (userPageTotal);
            Integer page=Integer.parseInt(request.getParameter("page"));
            Integer limit=Integer.parseInt(request.getParameter("limit"));
            pageBean.setPage(page);//设置默认页
            userQuery.setPage((page-1)*limit);
            userQuery.setLimit(limit);
            pageBean.setUserQuery(userQuery);
            pageBean.setUserList(userService.selectUserList(userQuery));
            System.out.println(pageBean);
            request.setAttribute("pageBean",pageBean);
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
            return;
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("beanUtils");
        BeanUtils.populate(userQuery,parameterMap);//改变了实体类的值
        System.out.println("beanUtils");
        /**
         * 已经改变了userQuery里面的值了
         */
        System.out.println("获取的session"+request.getSession().getAttribute("loginName"));
        Integer total=userService.selectCount(userQuery);
        pageBean.setLimit(userQuery.getLimit());//默认值的limit
        pageBean.setCount(total);//设置总数
        Integer userPageTotal=total%(userQuery.getLimit())==0?total/(userQuery.getLimit()):(total)/userQuery.getLimit()+1;
        pageBean.setUserPageTotal//设置总共有几页
                (userPageTotal);

        if (userQuery.getPage()<1){
            userQuery.setPage(1);
        }
        if (userQuery.getPage()>userPageTotal){
            userQuery.setPage(userPageTotal);
        }

        if (parameterMap.get("page")!=null){//前端传过来有值
            int page = userQuery.getPage();
            int limit = userQuery.getLimit();
            userQuery.setPage((page-1)*limit);
            System.out.println(userQuery.getPage());
            System.out.println(userQuery.getLimit());

            pageBean.setPage(page);
        }else {//没有值传过来，然后设置默认值
            pageBean.setPage(1);//默认值page=1
            userQuery.setPage(0);
        }
        pageBean.setUserQuery(userQuery);
        System.out.println(pageBean);
        pageBean.setUserList(userService.selectUserList(userQuery));
        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
    }

    /**
     * 验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
   public void checkCodeServlet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       System.out.println("到这了");
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       int width = 100;
       int height = 50;
       //1.创建一对象，在内存中图片(验证码图片对象)
       BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
       //2.美化图片
       //2.1 填充背景色
       Graphics g = image.getGraphics();//画笔对象
       g.setColor(Color.PINK);//设置画笔颜色
       g.fillRect(0,0,width,height);
       //2.2画边框
       g.setColor(Color.BLUE);
       g.drawRect(0,0,width - 1,height - 1);
       String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
       StringBuilder builder=new StringBuilder();
       //生成随机角标
       Random ran = new Random();
       for (int i = 1; i <= 4; i++) {
           int index = ran.nextInt(str.length());
           //获取字符
           char ch = str.charAt(index);//随机字符
           //2.3写验证码
           g.drawString(ch+"",width/5*i,height/2);
           builder.append(ch);
       }
       System.out.println(builder);
       HttpSession session = request.getSession();
       session.setAttribute("code",builder);
       //2.4画干扰线
       g.setColor(Color.GREEN);
       //随机生成坐标点
       for (int i = 0; i < 10; i++) {
           int x1 = ran.nextInt(width);
           int x2 = ran.nextInt(width);

           int y1 = ran.nextInt(height);
           int y2 = ran.nextInt(height);
           g.drawLine(x1,y1,x2,y2);
       }
       //3.将图片输出到页面展示


       ImageIO.write(image,"jpg",response.getOutputStream());
   }


   public void toRegister(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       List<Province> provinceList = provinceService.selectList();
       request.setAttribute("provinceList",provinceList);
       request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);

   }

   public void register(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");

       String name = request.getParameter("name");
       User user = userService.selectByName(name);
       Map<String, String[]> parameterMap = request.getParameterMap();
       User user2=new User();
       BeanUtils.populate(user2,parameterMap);
       if (user!=null){
           List<Province> provinceList = provinceService.selectList();
           request.setAttribute("provinceList",provinceList);
           request.setAttribute("registerMsg","用户名有人使用了，请重新输入");
           request.setAttribute("user",user2);
           request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
           return;//跳出register
       }

       user=new User();
       BeanUtils.populate(user,parameterMap);
       System.out.println(user);
       user.setPwd("123456");
       Integer integer = userService.insertUser(user);
       System.out.println(integer>0?"注册成功":"注册失败");
       request.getRequestDispatcher("/index.jsp").forward(request,response);
   }

   public void restoreAll(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       String page = request.getParameter("page");
       String limit = request.getParameter("limit");


       Integer i=userService.restoreAll();
       System.out.println(i>0?"恢复所有成功":"恢复所有失败");

       list(request,response);
   }

}
