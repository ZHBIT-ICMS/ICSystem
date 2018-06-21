package com.zhbit.service.impl;

import com.zhbit.dao.BaseDAO;
import com.zhbit.entity.*;
import com.zhbit.entity.base.DataGrid;
import com.zhbit.entity.base.PageBean;
import com.zhbit.entity.vo.VoUser;
import com.zhbit.exception.ValidateFieldsException;
import com.zhbit.service.UserService;
import com.zhbit.util.Encrypt;
import com.zhbit.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.*;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/6/8
 * @Time:15:49
 * 描述：
 * 用户服务接口实现类
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {

   private BaseDAO<User> userDao;
   private BaseDAO<Role> roleDao;
   private BaseDAO<InternationalStudent> internationalStudentDAO;
   private BaseDAO<UserRole> userRoleDAO;
   private BaseDAO<CollegeInfo> collegeInfoDAO;

    public BaseDAO<CollegeInfo> getCollegeInfoDAO() {
        return collegeInfoDAO;
    }
    @Autowired
    public void setCollegeInfoDAO(BaseDAO<CollegeInfo> collegeInfoDAO) {
        this.collegeInfoDAO = collegeInfoDAO;
    }


    public BaseDAO<User> getUserDao() {
        return userDao;
    }
    @Autowired
    public void setUserDao(BaseDAO<User> userDao) {
        this.userDao = userDao;
    }

    public BaseDAO<Role> getRoleDao() {
        return roleDao;
    }
    @Autowired
    public void setRoleDao(BaseDAO<Role> roleDao) {
        this.roleDao = roleDao;
    }

    public BaseDAO<InternationalStudent> getInternationalStudentDAO() {
        return internationalStudentDAO;
    }
    @Autowired
    public void setInternationalStudentDAO(BaseDAO<InternationalStudent> internationalStudentDAO) {
        this.internationalStudentDAO = internationalStudentDAO;
    }

    public BaseDAO<UserRole> getUserRoleDAO() {
        return userRoleDAO;
    }
    @Autowired
    public void setUserRoleDAO(BaseDAO<UserRole> userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    /**
     * 用户登录
     * @param voUser
     * @return
     */
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public VoUser login(VoUser voUser) {
       User tbUser=userDao.get("from User u where u.userNo = ? and u.password = ? and u.sign = ?",new Object[]{voUser.getUserNo(), Encrypt.e(voUser.getPassword()),voUser.getSign()});
       if(tbUser!=null){
           voUser.setId(tbUser.getId());
           voUser.setUserNo(tbUser.getUserNo());
           voUser.setUserName(tbUser.getUserName());
           voUser.setLoginIp(tbUser.getLoginIp());
           voUser.setLoginDate(tbUser.getLoginDate());
           voUser.setPhoto(tbUser.getPhoto());
           voUser.setPhone(tbUser.getPhone());
           voUser.setEmail(tbUser.getEmail());
           voUser.setBirthday(tbUser.getBirthday());
           voUser.setGender(tbUser.getGender());
           voUser.setLocked(tbUser.getLocked());
           voUser.setRemark(tbUser.getRemark());
           voUser.setCreateDate(tbUser.getCreateDate());
           voUser.setUpdateDate(tbUser.getUpdateDate());
           voUser.setCreator(tbUser.getCreator());
           voUser.setUpdater(tbUser.getUpdater());
           voUser.setCollegeId(tbUser.getCollegeInfo().getId());
           voUser.setCollegeName(tbUser.getCollegeInfo().getCollegeName());
           Map<String,String> authIdsMap= new HashMap<String,String>();
           String authIds="";
           String authNames="";
           Map<String,String> authUrlsMap= new HashMap<String, String>();
           String authUrls="";
           String roleIds="";
           String roleNames="";
           boolean b1=false;
           Set<UserRole> userRoles = tbUser.getUserRoles();
           if(userRoles!=null&&userRoles.size()>0){
                for(UserRole userRole:userRoles){
                    Role role = userRole.getRole();
                    if(b1){
                        roleIds+=",";
                        roleNames+=",";
                    }
                    roleIds+=role.getCid();
                    roleNames+=role.getCname();
                    b1=true;
                    Set<RoleAuth> roleAuths=role.getRoleAuths();
                    if(roleAuths!=null&&roleAuths.size()>0){
                        for(RoleAuth roleAuth:roleAuths){
                            Auth auth = roleAuth.getAuth();
                            authIdsMap.put(auth.getCid(),auth.getCname());
                            authUrlsMap.put(auth.getCid(),auth.getCurl());
                        }
                    }
                }

           }
           boolean b2=false;
           for(String id:authIdsMap.keySet()){
               if(b2){
                   authIds+=",";
                   authNames+=",";
               }
               authIds+=id;
               authNames+=authIdsMap.get(id);
               b2=true;
           }
           voUser.setAuthIds(authIds);
           voUser.setAuthNames(authNames);
           voUser.setRoleIds(roleIds);
           voUser.setRoleNames(roleNames);
           boolean b3=false;
           for(String id:authUrlsMap.keySet()){
               if(b3){
                   authUrls+=",";
               }
               authUrls+=authUrlsMap.get(id);
               b3=true;
           }
           voUser.setAuthUrls(authUrls);
           return  voUser;
       }
        return null;
    }

    /**
     * 保存用户信息
     * @param voUser
     * @throws ValidateFieldsException
     */
    @Override
    public void save(VoUser voUser) throws ValidateFieldsException {
     User u= new User();
     if(!isUniqueUser(voUser.getUserNo())){
         throw  new ValidateFieldsException("用户名已存在，请重新输入");
     }
     u.setUserNo(voUser.getUserNo());
     u.setUserName(voUser.getUserName());
     u.setBirthday(voUser.getBirthday());
     u.setEmail(voUser.getEmail());
     u.setLocked(voUser.getLocked());
     u.setGender(voUser.getGender());
     u.setSign(voUser.getSign());
     if(voUser.getCreateDate()==null){
         u.setCreateDate(new Date());
     }
     if(voUser.getUpdateDate()==null){
         u.setUpdateDate(new Date());
     }
     u.setPassword(Encrypt.e(voUser.getPassword()));
     u.setCollegeInfo(collegeInfoDAO.get(CollegeInfo.class,voUser.getCollegeId()));
     userDao.save(u);
     this.saveUserRole(voUser, u);
    }

    @Override
    public DataGrid dataGrid(VoUser voUser) {
        DataGrid j=new DataGrid();
        j.setRows(this.changeModel(this.find(voUser)));
        j.setTotal(this.total(voUser));
        return j;
    }

    /**
     *将User类型转换成 VoUser
     * @param users
     * @return
     */
    public List<VoUser> changeModel(List<User> users){
        List<VoUser> voUsers=new ArrayList<VoUser>();
        if(users!=null&&users.size()>0){
            for(User u:users){
                VoUser vu=new VoUser();
                vu.setId(u.getId());
                vu.setUserNo(u.getUserNo());
                vu.setUserName(u.getUserName());
                vu.setLoginIp(u.getLoginIp());
                vu.setLoginDate(u.getLoginDate());
                vu.setPhoto(u.getPhoto());
                vu.setPhone(u.getPhone());
                vu.setEmail(u.getEmail());
                vu.setBirthday(u.getBirthday());
                vu.setGender(u.getGender());
                vu.setLocked(u.getLocked());
                vu.setRemark(u.getRemark());
                vu.setSign(u.getSign());
                vu.setCreateDate(u.getCreateDate());
                vu.setUpdateDate(u.getUpdateDate());
                vu.setCreator(u.getCreator());
                vu.setUpdater(u.getUpdater());
                vu.setCollegeId(u.getCollegeInfo().getId());
                vu.setCollegeName(u.getCollegeInfo().getCollegeName());

                Set<UserRole> userRoles =u.getUserRoles();
                String roleIds="";
                String roleNames="";
                boolean b=false;
                if(userRoles!=null&&userRoles.size()>0){
                    for (UserRole userRole:userRoles){
                        if (userRole.getRole()!=null){
                            if(b){
                                roleIds+=",";
                                roleNames+=",";
                            }
                            roleIds+=userRole.getRole().getCid();
                            roleNames+=userRole.getRole().getCname();
                            b=true;
                        }
                    }
                }
                vu.setRoleIds(roleIds);
                vu.setRoleNames(roleNames);
                voUsers.add(vu);
            }
        }
        return  voUsers;
    }

    /**
     *
     * @param voUser
     * @return
     */
    private List<User> find(VoUser voUser){
        String hql="from User u where 1=1 ";
        List<Object> values=new ArrayList<Object>();
        hql=addWhere(voUser,hql,values);
        if (voUser.getSort()!=null&&voUser.getOrder()!=null){
            hql+=" order by "+ voUser.getSort()+" "+voUser.getOrder();
        }
        PageBean pageBean=new PageBean(voUser.getPage(),voUser.getRows());
        return userDao.find(hql,values,pageBean);
    }
    private Long total(VoUser voUser){
        String hql="select count(*) from User u where 1=1";
        List<Object> values=new ArrayList<Object>();
        hql=addWhere(voUser,hql,values);
        return userDao.count(hql,values);
    }
    private String addWhere(VoUser voUser,String hql,List<Object> values){
        if(StringUtil.isNotEmpty(voUser.getUserNo())){
            hql+=" and u.userNo like ? ";
            values.add("%%"+voUser.getUserNo().trim()+"%%");
        }
        if(StringUtil.isNotEmpty(voUser.getUserName())){
            hql+=" and u.userName like ? ";
            values.add("%%"+voUser.getUserName()+"%%");
        }
        if(voUser.getCollegeId()>0){
            hql+="and u.collegeInfo.id = ? ";
            values.add(" "+voUser.getCollegeId());
        }
        return hql;
    }

    /**
     *用户删除
     * @param ids
     */
    @Override
    public void delete(String ids) {
        System.out.println("Test Point ids:"+ids);
         if (ids!=null){
             for(String id:ids.split(",")){
                 if(!id.trim().equals("0")){
                     User u=userDao.get(User.class,Integer.parseInt(id.trim()));
                     if (u!=null){
                         userRoleDAO.executeHql("delete UserRole ur where ur.user = ? ",new Object[]{u});
                         userDao.delete(u);
                     }
                 }
             }
         }
    }

    /**
     *更新用户信息
     * @param voUser
     * @throws ValidateFieldsException
     */
    @Override
    public void update(VoUser voUser) throws ValidateFieldsException {
        System.out.println("```````````````````````userNO:"+voUser.getUserNo()+" id:"+voUser.getId()+" sign:"+voUser.getSign());
    /* if(!isUniqueUser(voUser.getUserNo())){
         throw new ValidateFieldsException("用户名已经存在，请重新输入！");
     }*/
     User u =userDao.get(User.class,voUser.getId());
     if(voUser.getUserNo().equals(u.getUserNo())||isUniqueUser(voUser.getUserNo())){
         if(StringUtil.isNotEmpty(voUser.getUserNo())){
             u.setUserNo(voUser.getUserNo());
         }
         if(StringUtil.isNotEmpty(voUser.getEmail())){
             u.setEmail(voUser.getUserNo());
         }
         if(StringUtil.isNotEmpty(voUser.getPassword())){
             u.setPassword(Encrypt.e(voUser.getPassword()));
         }
         if(voUser.getCollegeId()>0){
             u.setCollegeInfo(collegeInfoDAO.get(CollegeInfo.class,voUser.getCollegeId()));
         }
         if(voUser.getBirthday()!=null){
             u.setBirthday(voUser.getBirthday());
         }
         if(voUser.getUpdateDate()==null){
             u.setUpdateDate(voUser.getUpdateDate());
         }
         if (voUser.getGender()>=0){
             u.setGender(voUser.getGender());
         }
         if(StringUtil.isNotEmpty(voUser.getPhone())){
             u.setPhone(voUser.getPhone());
         }
        u.setSign(voUser.getSign());//修改用户身份
     }else {
         throw new ValidateFieldsException("用户名已经存在，请重新输入！");
      }
       /* if(StringUtil.isNotEmpty()){}
        if(StringUtil.isNotEmpty()){}*/
       this.saveUserRole(voUser,u);
    }

    /**
     *用户角色关系批量编辑
     * @param voUser
     */
    @Override
    public void editRole(VoUser voUser) {
       if(voUser.getIds()!=null){
           for (String id:voUser.getIds().split(",")){
               User u = userDao.get(User.class,Integer.parseInt(id));
               this.saveUserRole(voUser,u);
           }
       }
    }

    /**
     * 编辑用户信息
     * @param voUser
     */
    @Override
    public void editUserInfo(VoUser voUser) {
        if(StringUtil.isNotEmpty(voUser.getPassword())){
            User u=userDao.get(User.class,voUser.getId());
            u.setPassword(Encrypt.e(voUser.getPassword()));
        }
    }

    /**
     * 判断用户名是否唯一
     * @param userNo
     * @return
     */
    public boolean isUniqueUser(String userNo ){
        User tu=null;
        if(StringUtil.isNotEmpty(userNo)){
            tu=this.userDao.get("from User u where u.userNo= ? ",new String[]{userNo});
            if(tu==null){
                return true ;
            }
        }
        return  false;
    }

    /**
     * 保存用户和角色的关系
     * @param user
     * @param u
     */
    private void saveUserRole(VoUser user,User u){
        System.out.println("userId:"+u.getId());
        userRoleDAO.executeHql("delete UserRole ur where ur.user = ? ",new Object[]{u});
        if(user.getRoleIds()!=null){
            for(String id:user.getRoleIds().split(",")){
                UserRole userRole =new UserRole();
                userRole.setCid(UUID.randomUUID().toString());
                userRole.setRole(roleDao.get(Role.class,id.trim()));
                userRole.setUser(u);
                userRoleDAO.save(userRole);
            }
        }
    }

}
