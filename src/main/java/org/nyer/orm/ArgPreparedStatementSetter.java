package org.nyer.orm;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.ParameterDisposer;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.StatementCreatorUtils;
/*    */ 
/*    */ class ArgPreparedStatementSetter
/*    */   implements PreparedStatementSetter, ParameterDisposer
/*    */ {
/*    */   private final Object[] args;
/*    */ 
/*    */   public ArgPreparedStatementSetter(Object[] args)
/*    */   {
/* 38 */     this.args = args;
/*    */   }
/*    */ 
/*    */   public void setValues(PreparedStatement ps) throws SQLException
/*    */   {
/* 43 */     if (this.args != null)
/* 44 */       for (int i = 0; i < this.args.length; ++i) {
/* 45 */         Object arg = this.args[i];
/* 46 */         if (arg instanceof SqlParameterValue) {
/* 47 */           SqlParameterValue paramValue = (SqlParameterValue)arg;
/* 48 */           StatementCreatorUtils.setParameterValue(ps, i + 1, paramValue, paramValue.getValue());
/*    */         }
/*    */         else {
/* 51 */           StatementCreatorUtils.setParameterValue(ps, i + 1, -2147483648, arg);
/*    */         }
/*    */       }
/*    */   }
/*    */ 
/*    */   public void cleanupParameters()
/*    */   {
/* 58 */     StatementCreatorUtils.cleanupParameters(this.args);
/*    */   }
/*    */ }

