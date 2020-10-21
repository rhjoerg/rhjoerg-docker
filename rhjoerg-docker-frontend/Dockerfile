FROM openjdk:11-jre

ENV JETTY_VERSION 9.4.32.v20200930
ENV JETTY_HOME /usr/local/jetty
ENV JETTY_BASE /var/lib/jetty
ENV TMPDIR /tmp/jetty
ENV PATH $JETTY_HOME/bin:$PATH
ENV JETTY_TGZ_URL https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-home/$JETTY_VERSION/jetty-home-$JETTY_VERSION.tar.gz

RUN \
	mkdir -p "$JETTY_HOME" ; \
	cd $JETTY_HOME ; \
	curl -SL "$JETTY_TGZ_URL" -o jetty.tar.gz ; \
	tar -xf jetty.tar.gz --strip-components=1 ; \
	sed -i '/jetty-logging/d' etc/jetty.conf ; \
	mkdir -p "$JETTY_BASE" ; \
	cd $JETTY_BASE ; \
	java -jar "$JETTY_HOME/start.jar" --create-startd --add-to-start="server,http" ; \
	mkdir -p "$TMPDIR" ; \
	groupadd -r jetty && useradd -r -g jetty jetty ; \
	chown -R jetty:jetty "$JETTY_HOME" "$JETTY_BASE" "$TMPDIR" ; \
	usermod -d $JETTY_BASE jetty ; \
	rm -rf /tmp/hsperfdata_root ; \
	rm -fr $JETTY_HOME/jetty.tar.gz* ; \
	java -jar "$JETTY_HOME/start.jar" --list-config ;

WORKDIR $JETTY_BASE
USER jetty
EXPOSE 8080
CMD ["java","-jar","/usr/local/jetty/start.jar"]
