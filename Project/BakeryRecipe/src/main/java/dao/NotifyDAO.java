/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Comment;
import dto.Notify;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private static final String NOTIFY_COMMENT = "";

    public static boolean notifyCMT(String receiveID, String recipeID) {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = true;
        Comment cmt = new Comment();

        try {
            cn = DBUtils.getConnection();
            ptm = cn.prepareStatement(NOTIFY_COMMENT);

        } catch (Exception e) {
        } finally {
        }
        return check;

    }

    //sẽ lấy những phần notify có type là Comment
    private static final String LIST_COMMENT = "";

    public static List<Comment> commentNotify(int userID) {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Comment> cmtList = new ArrayList<>();
        try {

        } catch (Exception e) {
        } finally {
        }
        return cmtList;
    }

    //việc like hay comment hoặc save nó sẽ đơn giản hơn với cmt
    private static final String NOTIFY_FOLLOW = "";

    public static boolean notifyFL() {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = true;
        try {

        } catch (Exception e) {
        } finally {
        }
        return true;
    }

    //việc hình thành notify trong phần cmt 
    //khi 1 người like bài viết của một người 
    // thì người viết sẽ nhận đc notify của người like 
    //
    private static final String NOTIFY_LIKE = "";

    public static boolean notifyLIKE() {
        return true;
    }

    //sẽ lấy những phần notify có type là like 
    private static final String LIST_LIKE = "";

    public static List<Notify> notifyLike(int userID) {
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Notify> notiLike = new ArrayList<>();
        try {

        } catch (Exception e) {
        } finally {
        }
        return notiLike;
    }

    private static final String NOTIFY_SAVE = "";

    public static boolean notifySave(int recipeId, int userID) {
        Connection cnn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = true;
        try {

        } catch (Exception e) {
        } finally {
        }
        return check;

    }

    private static final String LIST_SAVE = "";

    public static List<Notify> notifySave(int userID) {
        Connection cn = null;

        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<Notify> notifyList = new ArrayList<>();
        try {

        } catch (Exception e) {
        } finally {
        }
        return notifyList;
    }

    private static final String UPDATE_SEEN = "";

    public static boolean updateActive() {
        return true;
    }

    private static final String DELETE_NOTIFY = "";

    public static boolean deleteNotify() {
        return true;
    }

    private static final String COUNT_NOTIFY = "";

    public static int countNotify(int userID) {
        int countCheck = 0;
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {

        } catch (Exception e) {
        } finally {
        }
        return countCheck;

    }
}
