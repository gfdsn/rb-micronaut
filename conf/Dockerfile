FROM macbre/nginx-http3:1.25.2

USER root

RUN [ -f /etc/nginx/conf.d/default.conf ] && rm /etc/nginx/conf.d/default.conf || true

COPY nginx.conf /etc/nginx/

EXPOSE 9999

CMD ["nginx", "-g", "daemon off;"]
