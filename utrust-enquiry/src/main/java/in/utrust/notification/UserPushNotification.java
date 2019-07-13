package in.utrust.notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserPushNotification 
{
	List<ConsumerNotifications> consumerNotifications;
	
	public List<ConsumerNotifications> getConsumerNotifications() {
		if(null == consumerNotifications) {
			consumerNotifications = new ArrayList<ConsumerNotifications>();
		}
		return consumerNotifications;
	}

	public void setConsumerNotifications(List<ConsumerNotifications> consumerNotifications) {
		this.consumerNotifications = consumerNotifications;
	}

	public static class ConsumerNotifications
	{
		private boolean mutable_content;
		private boolean content_available;
		private Notification notification;
		private Data data;

		public boolean isMutable_content() {
			return mutable_content;
		}

		public void setMutable_content(boolean mutable_content) {
			this.mutable_content = mutable_content;
		}
		public boolean isContent_available() {
			return content_available;
		}

		public void setContent_available(boolean content_available) {
			this.content_available = content_available;
		}

		public Notification getNotification() {
			return notification;
		}

		public void setNotification(Notification notification) {
			this.notification = notification;
		}

		public Data getData() {
			return data;
		}

		public void setData(Data data) {
			this.data = data;
		}

		public static class Notification
		{
			private Long badge;
			private String title;
			private String body;
			private String sound;
			private String click_action;
			
			public Long getBadge() {
				return badge;
			}
			public void setBadge(Long badge) {
				this.badge = badge;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getBody() {
				return body;
			}
			public void setBody(String body) {
				this.body = body;
			}
			public String getSound() {
				return sound;
			}
			public void setSound(String sound) {
				this.sound = sound;
			}
			public String getClick_action() {
				return click_action;
			}
			public void setClick_action(String click_action) {
				this.click_action = click_action;
			}
		}
		
		public static class Data
		{
			private String type;
			private Long notification_timestamp;
			private boolean read_status;
			private String action;
			private String url_path;
			private Map<String, Object> extras;
			
			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public Long getNotification_timestamp() {
				return notification_timestamp;
			}

			public void setNotification_timestamp(Long notification_timestamp) {
				this.notification_timestamp = notification_timestamp;
			}

			public boolean isRead_status() {
				return read_status;
			}

			public void setRead_status(boolean read_status) {
				this.read_status = read_status;
			}

			public String getAction() {
				return action;
			}

			public void setAction(String action) {
				this.action = action;
			}

			public String getUrl_path() {
				return url_path;
			}

			public void setUrl_path(String url_path) {
				this.url_path = url_path;
			}

			public Map<String, Object> getExtras() {
				return extras;
			}

			public void setExtras(Map<String, Object> extras) {
				this.extras = extras;
			}
		}
	}
	
}
