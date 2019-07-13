package in.utrust.notification;

import java.util.Map;

public class AndroidPushNotification {
		private Data data;
		public Data getData() {
			return data;
		}
		public void setData(Data data) {
			this.data = data;
		}

		public static class Data {
			private String title;
			private String body;
			private String type;
			private Long notification_timestamp;
			private boolean read_status;
			private String action;
			private String url_path;
			private Map<String, Object> extras;

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
