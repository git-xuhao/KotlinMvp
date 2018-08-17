package com.hazz.kotlinmvp.utils

import android.content.Context
import android.content.SharedPreferences
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import android.util.Base64
import java.io.*


/**
 * Created by xuhao on 2017/12/11.
 * desc:kotlin委托属性+SharedPreference实例(记录视频观看记录的）
 */
class WatchHistoryUtils {

    companion object {
        /**
         * 保存在手机里面的文件名
         */
        private val FILE_NAME = "kotlin_mvp_file"

        /**
         * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
         *
         * @param context
         * @param key
         * @param object
         */
        fun put(context: Context, key: String, `object`: Any) {

            val sp = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE)
            val editor = sp.edit()

            when (`object`) {
                is String -> editor.putString(key, `object`)
                is Int -> editor.putInt(key, `object`)
                is Boolean -> editor.putBoolean(key, `object`)
                is Float -> editor.putFloat(key, `object`)
                is Long -> editor.putLong(key, `object`)
                else -> editor.putString(key, `object`.toString())
            }

            SharedPreferencesCompat.apply(editor)
        }

        /**
         * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
         *
         * @param context
         * @param key
         * @param defaultObject
         * @return
         */
        operator fun get(context: Context, key: String, defaultObject: Any): Any? {
            val sp = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE)

            return when (defaultObject) {
                is String -> sp.getString(key, defaultObject)
                is Int -> sp.getInt(key, defaultObject)
                is Boolean -> sp.getBoolean(key, defaultObject)
                is Float -> sp.getFloat(key, defaultObject)
                is Long -> sp.getLong(key, defaultObject)
                else -> null
            }

        }

        /**
         * 移除某个key值已经对应的值
         *
         * @param context
         * @param key
         */
        fun remove(context: Context, key: String) {
            val sp = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.remove(key)
            SharedPreferencesCompat.apply(editor)
        }

        /**
         * 清除所有数据
         *
         * @param context
         */
        fun clear(context: Context) {
            val sp = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.clear()
            SharedPreferencesCompat.apply(editor)
        }

        /**
         * 查询某个key是否已经存在
         *
         * @param context
         * @param key
         * @return
         */
        fun contains(context: Context, key: String): Boolean {
            val sp = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE)
            return sp.contains(key)
        }

        /**
         * 返回所有的键值对
         *
         * @param context
         * @return
         */
        fun getAll(context: Context): Map<String, *> {
            val sp = context.getSharedPreferences(FILE_NAME,
                    Context.MODE_PRIVATE)
            return sp.all
        }


        /**
         * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
         *
         * @author zhy
         */
        private object SharedPreferencesCompat {
            private val sApplyMethod = findApplyMethod()

            /**
             * 反射查找apply的方法
             *
             * @return
             */
            private fun findApplyMethod(): Method? {
                try {
                    val clz = SharedPreferences.Editor::class.java
                    return clz.getMethod("apply")
                } catch (e: NoSuchMethodException) {
                }

                return null
            }

            /**
             * 如果找到则使用apply执行，否则使用commit
             *
             * @param editor
             */
            fun apply(editor: SharedPreferences.Editor) {
                try {
                    if (sApplyMethod != null) {
                        sApplyMethod.invoke(editor)
                        return
                    }
                } catch (e: IllegalArgumentException) {
                } catch (e: IllegalAccessException) {
                } catch (e: InvocationTargetException) {
                }

                editor.commit()
            }
        }

        /*****************文件名可变，用于存储各种历史记录********/


        /**
         * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
         *
         * @param context
         * @param key
         * @param object
         */
        fun put(fileName: String, context: Context, key: String, `object`: Any) {

            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            val editor = sp.edit()

            when (`object`) {
                is String -> editor.putString(key, `object`)
                is Int -> editor.putInt(key, `object`)
                is Boolean -> editor.putBoolean(key, `object`)
                is Float -> editor.putFloat(key, `object`)
                is Long -> editor.putLong(key, `object`)
                else -> editor.putString(key, `object`.toString())
            }

            SharedPreferencesCompat.apply(editor)
        }

        /**
         * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
         *
         * @param context
         * @param key
         * @param defaultObject
         * @return
         */
        operator fun get(fileName: String, context: Context, key: String, defaultObject: Any): Any? {
            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)

            return when (defaultObject) {
                is String -> sp.getString(key, defaultObject)
                is Int -> sp.getInt(key, defaultObject)
                is Boolean -> sp.getBoolean(key, defaultObject)
                is Float -> sp.getFloat(key, defaultObject)
                is Long -> sp.getLong(key, defaultObject)
                else -> null
            }

        }

        /**
         * 移除某个key值已经对应的值
         *
         * @param context
         * @param key
         */
        fun remove(fileName: String, context: Context, key: String) {
            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.remove(key)
            SharedPreferencesCompat.apply(editor)
        }

        /**
         * 清除所有数据
         *
         * @param context
         */
        fun clear(fileName: String, context: Context) {
            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.clear()
            SharedPreferencesCompat.apply(editor)
        }

        /**
         * 查询某个key是否已经存在
         *
         * @param context
         * @param key
         * @return
         */
        fun contains(fileName: String, context: Context, key: String): Boolean {
            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            return sp.contains(key)
        }

        /**
         * 返回所有的键值对
         *
         * @param context
         * @return
         */
        fun getAll(fileName: String, context: Context): Map<String, *> {
            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            return sp.all
        }


        fun putObject(fileName: String,context: Context, `object`: Any?,
                      key: String): Boolean {
            val sp = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            if (`object` == null) {
                val editor = sp.edit().remove(key)
                return editor.commit()
            }
            val baos = ByteArrayOutputStream()
            var oos: ObjectOutputStream?
            try {
                oos = ObjectOutputStream(baos)
                oos.writeObject(`object`)
            } catch (e: IOException) {
                e.printStackTrace()
                return false
            }

            // 将对象放到OutputStream中
            // 将对象转换成byte数组，并将其进行base64编码
            val objectStr = String(Base64.encode(baos.toByteArray(),
                    Base64.DEFAULT))
            try {
                baos.close()
                oos.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            val editor = sp.edit()
            editor.putString(key, objectStr)
            return editor.commit()
        }

        /**
         * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
         *
         * @param context
         * @param key
         * @return
         */
        fun getObject(fileName: String,context: Context, key: String): Any? {
            val sharePre = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE)
            try {
                val wordBase64 = sharePre.getString(key, "")
                // 将base64格式字符串还原成byte数组
                if (wordBase64 == null || wordBase64 == "") { // 不可少，否则在下面会报java.io.StreamCorruptedException
                    return null
                }
                val objBytes = Base64.decode(wordBase64.toByteArray(),
                        Base64.DEFAULT)
                val bais = ByteArrayInputStream(objBytes)
                val ois = ObjectInputStream(bais)
                // 将byte数组转换成product对象
                val obj = ois.readObject()
                bais.close()
                ois.close()
                return obj
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }

        /**
         * 序列化对象

         * @param person
         * *
         * @return
         * *
         * @throws IOException
         */
        @Throws(IOException::class)
        private fun <A> serialize(obj: A): String {
            val byteArrayOutputStream = ByteArrayOutputStream()
            val objectOutputStream = ObjectOutputStream(
                    byteArrayOutputStream)
            objectOutputStream.writeObject(obj)
            var serStr = byteArrayOutputStream.toString("ISO-8859-1")
            serStr = java.net.URLEncoder.encode(serStr, "UTF-8")
            objectOutputStream.close()
            byteArrayOutputStream.close()
            return serStr
        }

        /**
         * 反序列化对象

         * @param str
         * *
         * @return
         * *
         * @throws IOException
         * *
         * @throws ClassNotFoundException
         */
        @Suppress("UNCHECKED_CAST")
        @Throws(IOException::class, ClassNotFoundException::class)
        private fun <A> deSerialization(str: String): A {
            val redStr = java.net.URLDecoder.decode(str, "UTF-8")
            val byteArrayInputStream = ByteArrayInputStream(
                    redStr.toByteArray(charset("ISO-8859-1")))
            val objectInputStream = ObjectInputStream(
                    byteArrayInputStream)
            val obj = objectInputStream.readObject() as A
            objectInputStream.close()
            byteArrayInputStream.close()
            return obj
        }


    }


}
