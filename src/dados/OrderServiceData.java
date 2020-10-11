package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dados_interface.IGenericDados;
import objetoAcessoDados.OrderServiceObjAccessData;

public class OrderServiceData implements IGenericDados<OrderServiceObjAccessData>{
	
	private Connection connection=null;
	
	public OrderServiceData(Connection conn) {
		connection = conn;
	}

	@Override
	public List<OrderServiceObjAccessData> getList() {
		String query = "Select * from ORDERSERVICE";
		PreparedStatement pst = null;
		ResultSet res = null;
		List<OrderServiceObjAccessData> orderServices = new ArrayList<OrderServiceObjAccessData>();
		
		try {
			pst = connection.prepareStatement(query);
			res = pst.executeQuery();
			
			while(res.next()) {
				OrderServiceObjAccessData orderService =
						new OrderServiceObjAccessData(
								res.getInt("Id"),
								res.getInt("day"),
								res.getInt("month"),
								res.getInt("year"),
								res.getInt("startHour"),
								res.getInt("startMinute"),
								res.getInt("endHour"),
								res.getInt("endMinute"),
								res.getInt("idEquipment"),
								res.getInt("idTechinican"),
								res.getString("description"),
								res.getInt("typeService"));
				orderServices.add(orderService);
			}
			res.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
			
		}
		
		return orderServices;
	}

	@Override
	public OrderServiceObjAccessData get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		String cmd = "delete from ORDERSERVICE where Id=?";
		try {
			PreparedStatement pst = connection.prepareStatement(cmd);
			pst.setInt(1, id);
			pst.close();
		}catch(Exception e) {
			throw new Error(e.getMessage());
		}	
	}

}
