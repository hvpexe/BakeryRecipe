/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Comment;
import dto.Notify;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author VO MINH MAN
 */
public class NotifyDAO {
    // làm xoay quanh 4 dạng  chính là follow ,like ,comment ,save
//    CREATE TABLE [dbo].[Notificaition](
//	[ID] [int] IDENTITY(1,1) NOT NULL,
//	[senderID] [int] NOT NULL, dùng để connect với [UserID2] của Follow table/ [UserID] của Like table/[UserID] của Save table
//	[recipeID] [int] ,dùng để connect với [recipeID] của Like table  và Save table
//	[CommentID] [int] NULL,dùng để connect với [CommentID] của Comment table(không cần thiết )
//	[TypeofNotify] [nvarchar](50) NOT NULL,
//	[receiverID] [int] NOT NULL,dùng để connect với [UserID] của Follow table
//	[isSeen] [bit] NOT NULL,thì người dùng nhấn vô thì
//	[isDelete] [bit] NOT NULL
//	
// CONSTRAINT [PK__Posts__AA1260380751D4EE] PRIMARY KEY CLUSTERED 
//(
//	[ID] ASC
//)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
//) ON [PRIMARY]
//GO

    //việc hình thành notify trong phần cmt 
    //khi 1 người cmt trong bài viết của một người 
    // thì người viết sẽ nhận đc notify của người cmt 
    //một bài viết có thể nhận đc nhiều comment từ một người 
    private static final String NOTIFY_COMMENT = "INSERT INTO [dbo].[Notificaition]([SenderID],[RecipeID],[CommentID],[ReceiverID],[TypeofNotify],"
            + "[DateReceive],[IsSeen],[IsDelete])\n"
            + "VALUES (?,?,?,?,?,?,?,?)";
//ý tưởng để lấy đc id của cmt sau khi mới cmt là ta canh vào thời gian mới nhập của cmt tạo hàm take CommentIDbyTime(String time);

    public static boolean AddNotifyComment(int senderID, int recipeID, int cmtID, int userID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = true;
        int senderId = userID;
        Timestamp currentDate = new Timestamp(System.currentTimeMillis());
        int receiverId = UserDAO.userDetail(recipeID).getId();

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(NOTIFY_COMMENT);
            ptm.setInt(1, senderId);
            ptm.setInt(2, recipeID);
            ptm.setInt(3, cmtID);
            ptm.setInt(4, receiverId);
            ptm.setString(5, "comment");
            ptm.setTimestamp(6, currentDate);
            ptm.setBoolean(7, false);
            ptm.setBoolean(8, false);
            check = ptm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;

    }

    //sẽ lấy những phần notify có type là Comment
    private static final String LIST_COMMENT = "SELECT  [ID],[SenderID],[RecipeID],[CommentID],[ReceiverID],[TypeofNotify]"
            + ",[DateReceive],[IsSeen],[IsDelete]\n"
            + "FROM [dbo].[Notificaition]\n"
            + "WHERE [SenderID] = ? and [RecipeID] =? and[TypeofNotify] =?";

    public static List<Notify> commentNotify(int recipeID) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Notify> cmtList = new ArrayList<>();
        int senderId = UserDAO.userDetail(recipeID).getId();
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(LIST_COMMENT);
            ptm.setInt(1, senderId);
            ptm.setInt(2, recipeID);
            ptm.setString(3, "comment");
            rs = ptm.executeQuery();
            while (rs.next()) {
                int notifyID = rs.getInt("ID");
                int ReceiverID = rs.getInt("ReceiverID");
                int commentID = rs.getInt("CommentID");
                Date date = rs.getDate("DateReceive");
                boolean isSeen = rs.getBoolean("isSeen");
                boolean isDelete = rs.getBoolean("IsDelete");
                Notify notify = new Notify(notifyID, senderId, recipeID, commentID, ReceiverID, "comment", date, isSeen, isDelete);

                cmtList.add(notify);
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return cmtList;
    }

    //việc like hay comment hoặc save nó sẽ đơn giản hơn với cmt
    private static final String NOTIFY_FOLLOW = 
            "INSERT INTO [dbo].[Notificaition]([SenderID],[ReceiverID],[TypeofNotify],"
            + "[DateReceive],[IsSeen],[IsDelete])\n"
            + "VALUES (?,?,?,?,?,?)";

    public static boolean notifyFL(int senderID, int receiverID) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = true;
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
//            int senderId = UserDAO.userDetail(recipeID).getId();
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(NOTIFY_FOLLOW);
            ptm.setInt(1, senderID);
            ptm.setInt(2, receiverID);
            ptm.setString(3, "follow");
            ptm.setDate(4, currentDate);
            ptm.setBoolean(5, false);
            ptm.setBoolean(6, false);
//            ptm.setInt(7,recipeID );
            check = ptm.executeUpdate() > 0 ? true : false;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return true;
    }
    private static final String NOTIFY_FOLLOWLIST = "SELECT  [ID],[SenderID],[ReceiverID],[TypeofNotify]"
            + ",[DateReceive],[IsSeen],[IsDelete]\n"
            + "FROM [dbo].[Notificaition]\n"
            + "WHERE [ReceiverID] = ? and[TypeofNotify] =?";

    public static List<Notify> followList(int receiverID) throws SQLException {
        Connection cnn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Notify> notifyList = new ArrayList<>();
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareStatement(NOTIFY_FOLLOWLIST);
            ptm.setInt(1, receiverID);
            ptm.setString(1, "follow");
            rs = ptm.executeQuery();
            while (rs.next()) {
                int followID = rs.getInt("ID");
                int senderId = rs.getInt("SenderID");
                Date datefl = rs.getDate("DateReceive");
                boolean isSeen = rs.getBoolean("IsSeen");
                boolean isDelete = rs.getBoolean("IsDelete");
                Notify notify = new Notify(followID, senderId, receiverID, "follow", datefl, isSeen, isDelete);
                notifyList.add(notify);
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return notifyList;

    }
    //việc hình thành notify trong phần cmt 
    //khi 1 người like bài viết của một người 
    // thì người viết sẽ nhận đc notify của người like 
    //
    private static final String NOTIFY_LIKE = "INSERT INTO [dbo].[Notificaition]([SenderID],[RecipeID],"
            + "[ReceiverID],[TypeofNotify],[DateReceive],[IsSeen],[IsDelete])\n"
            + "VALUES (?,?,?,?,?,?,?)";

    public static boolean notifyLIKE(int recipeID, int senderID) throws SQLException {
        Connection cnn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int receiverID = UserDAO.userDetail(recipeID).getId();
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String date = dateFormat.format(currentDate);
        boolean check = false;
        try {
            cnn = DBUtils.getConnection();
            ptm = cnn.prepareStatement(NOTIFY_LIKE);
            ptm.setInt(1, senderID);
            ptm.setInt(2, recipeID);
            ptm.setInt(3, receiverID);
            ptm.setString(4, "like");
            ptm.setDate(5, currentDate);
            ptm.setBoolean(6, false);
            ptm.setBoolean(7, false);
            check = ptm.executeUpdate() > 0 ? true : false;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cnn != null) {
                cnn.close();
            }
        }
        return check;
    }

    //sẽ lấy những phần notify có type là like 
    private static final String LIST_LIKE = "SELECT[ID],[SenderID],[RecipeID],[ReceiverID],"
            + "[TypeofNotify],[DateReceive],[IsSeen],[IsDelete]\n"
            + "FROM [dbo].[Notificaition]\n"
            + "WHERE  [RecipeID] =? and[TypeofNotify] =?";

    public static List<Notify> notifyLike(int recipeID) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Notify> notifyLike = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(LIST_LIKE);
            ptm.setInt(1, recipeID);
            ptm.setString(2, "like");
            rs = ptm.executeQuery();
            while (rs.next()) {
                int likeId = rs.getInt("ID");
                int senderID = rs.getInt("SenderID");
                int receiverID = rs.getInt("ReceiverID");
                boolean isSeen = rs.getBoolean("isSeen");
                boolean isDelete = rs.getBoolean("IsDelete");
                Date date = rs.getDate("DateReceive");
                Notify notify = new Notify(likeId, senderID, recipeID, receiverID, "like", date, isSeen, isDelete);
                notifyLike.add(notify);
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return notifyLike;
    }

    //hàm dùng để cập nhật tình trạng của trạng thái khi người dùng nhấn vào thì sẽ chuyển trạng thái về true
    private static final String UPDATE_SEEN = "UPDATE  [dbo].[Notificaition]\n" +
"            SET [IsSeen] =? \n" +
"             WHERE [ID] =?";

    public static boolean updateSeen(int notifyID) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(UPDATE_SEEN);
            ptm.setString(1, "True");
            ptm.setInt(2, notifyID);
            check = ptm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }

    private static final String DELETE_NOTIFY = "UPDATE [dbo].[Instruction] \n"
            + "SET [IsDelete] =true\n"
            + "WHERE [ID] =? ";

    public static boolean deleteNotify(int notifyID) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(DELETE_NOTIFY);
            ptm.setInt(1, notifyID);
            check = ptm.executeUpdate() > 0 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return check;
    }
//dùng để thông báo số notify bạn chưa coi và khi nhấn vào sẽ seen thì bị trừ đi

    private static final String COUNT_NOTIFY = "SELECT COUNT([ID]) as 'Count'\n"
            + "FROM [dbo].[Notificaition]\n"
            + "WHERE [ID] =? and  [IsSeen] = false;";

    public static int countNotify(int userID) throws SQLException {
        int countCheck = 0;
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int result = 0;

        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(COUNT_NOTIFY);
            ptm.setInt(1, userID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                result = rs.getInt("Count");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return result;

    }

    private static final String GET_ALL = "SELECT	[ID],[SenderID],[RecipeID],[CommentID],[ReceiverID],[TypeofNotify],[DateReceive],[IsSeen],[IsDelete]\n"
            + "FROM [dbo].[Notificaition]\n"
            + "WHERE  [ReceiverID]= ?  AND [IsDelete] ='FALSE'";

    public static List<Notify> getAllNotify(int receiverID) throws SQLException {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Notify> notifyList = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(GET_ALL);
            ptm.setInt(1, receiverID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int idnotify = rs.getInt("ID");
                int senderID = rs.getInt("SenderID");
                int recipeID = rs.getInt("RecipeID");
                int commentID = rs.getInt("CommentID");
//        int receiverID =rs.getInt("ReceiverID");
                String notifyType = rs.getString("TypeofNotify");
                Date tmp = rs.getDate("DateReceive");
                boolean isSeen = rs.getBoolean("IsSeen");
                boolean isDelete = rs.getBoolean("IsDelete");
                String nameofSender = UserDAO.getUserByID(senderID).getName();
                String pictureofBaker = UserDAO.getUserByID(senderID).getAvatar();
                if (recipeID != 0) {
                    String pictureofRecipe = RecipeDAO.getRecipeByID(recipeID).getName();
                    Notify noti1 = new Notify(idnotify, senderID, recipeID, commentID, receiverID, notifyType, tmp, isSeen, isDelete, nameofSender, pictureofBaker, pictureofRecipe);
                    notifyList.add(noti1);
                } else {
                    Notify noti = new Notify(idnotify, senderID, recipeID, commentID, receiverID, notifyType, tmp, isSeen, isDelete, nameofSender, pictureofBaker, "");
//Notify noi = new Notify            
                    notifyList.add(noti);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }

        }
        return notifyList;
    }

   
}
